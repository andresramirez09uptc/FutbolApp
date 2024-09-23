package com.task.futbolapp.data.api.retrtofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private var apiService: ApiService? = null
    private const val BASE_URL = "https://api.football-data.org/v4/"
    private const val API_KEY = "5a16000ce450441a95dc4b6e10cdb657"
    fun getInstance(): ApiService {
        val client = OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(API_KEY))
            .build()

        return apiService ?: Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}
