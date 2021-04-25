package com.android.jetpacprodua.data.source.remote.api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig {

    companion object {
        fun getApiService(): ApiService {
            val logInter =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val myClient = OkHttpClient.Builder()
                .addInterceptor(logInter)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(myClient)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}