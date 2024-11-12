package com.delgado.angel.poketinder2024

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel(
    val context: Context
): ViewModel() {

    val inputsError = MutableLiveData<Boolean>()
    val emailError = MutableLiveData<Boolean>()
    val passwordLengthError = MutableLiveData<Boolean>()
    val passwordMatchError = MutableLiveData<Boolean>()
    val registerSuccess = MutableLiveData<Boolean>()


    private var sharedPreferencesRepository: SharedPreferencesRepository =
        SharedPreferencesRepository().also {
            it.setSharedPreference(context)
        }

    fun validateInputs(email: String, password: String, passwordAgain: String) {
        if (isEmptyInputs(email, password, passwordAgain)){
            inputsError.postValue(true)
            return
        }

        if (!email.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))) {
            emailError.postValue(true)
            return
        }

        if (8 > password.length) {
            passwordLengthError.postValue(true)
            return
        }

        if (password != passwordAgain) {
            passwordMatchError.postValue(true)
            return
        }

        sharedPreferencesRepository.saveUserEmail(email)
        sharedPreferencesRepository.saveUserPassword(password)

        registerSuccess.postValue(true)
        return
    }

    private fun isEmptyInputs(email: String, password: String, passwordAgain: String) = email.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()
}