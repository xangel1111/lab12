package com.delgado.angel.poketinder2024

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("/pokemon/{id}")
    fun getPokemon(@Path("id") pokemonId: Int): Call<String>
}