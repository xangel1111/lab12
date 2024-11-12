package com.delgado.angel.poketinder2024

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitInstance {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val pokeApiService: PokeApiService = retrofit.create(PokeApiService::class.java)
}