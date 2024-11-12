package com.delgado.angel.poketinder2024

import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main {
    @Test
    fun getPokemon() {
        getPokemonJson(1)
    }

    private fun getPokemonJson(pokemonId: Int){
        val call = RetrofitInstance.pokeApiService.getPokemon(pokemonId);
        call.enqueue(object: Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val jsonResponse = response.body()
                    println("Respuesta JSON: $jsonResponse")
                } else {
                    println("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
}

