package com.example.watercarriertest.retrofit

import com.example.watercarriertest.MainActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitRetrofit {

    fun initRetrofit(): MainApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(MainActivity.MAIN_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MainApi::class.java)
    }
}