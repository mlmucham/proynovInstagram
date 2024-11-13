package edu.isil.proynovinstagram

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstagramApi {
    private const val BASE_URL = "https://graph.instagram.com/"

    fun createService(): InstagramApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(InstagramApiService::class.java)
    }
}
