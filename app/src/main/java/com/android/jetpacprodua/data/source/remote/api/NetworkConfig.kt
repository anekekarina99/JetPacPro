package com.android.jetpacprodua.data.source.remote.api


import com.android.jetpacprodua.utils.Constant.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class NetworkConfig {

    companion object {
        fun getApiService(): ApiService {
            val logInter =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val myClient = OkHttpClient.Builder()
                .addInterceptor(logInter)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .client(myClient)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}