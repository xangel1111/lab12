package com.delgado.angel.poketinder2024

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.delgado.angel.poketinder2024.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerViewModel = RegisterViewModel(this)
        observeButtons()
        observeValues()
    }

    private fun observeButtons() {
        binding.btnLogin.setOnClickListener {
            finish()
        }
        binding.btnBackClose.setOnClickListener {
            finish()
        }

        binding.btnRegister.setOnClickListener {
            registerViewModel.validateInputs(
                email = binding.edtEmail.text.toString(),
                password = binding.edtPassword.text.toString(),
                passwordAgain = binding.edtPassword2.text.toString()
            )
        }
    }

    private fun observeValues() {

        registerViewModel.registerSuccess.observe(this) {
            Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }
        registerViewModel.inputsError.observe(this) {
            Toast.makeText(this, "Ingrese los datos completos", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.emailError.observe(this) {
            Toast.makeText(this, "El formato de correo es incorrecto", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.passwordLengthError.observe(this) {
            Toast.makeText(this, "La contraseña debe tener 8 caracteres como mínimo", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.passwordMatchError.observe(this) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }

    }
}