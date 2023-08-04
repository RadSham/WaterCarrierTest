package com.example.watercarriertest.retrofit

import com.example.watercarriertest.MainActivity.Companion.DATA_PATH_URL
import retrofit2.Response
import retrofit2.http.GET

interface MainApi {
    @GET(DATA_PATH_URL)
    suspend fun getGoods(): Response<Goods>
}