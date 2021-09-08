package com.example.android.crudinnocv.network

import com.example.android.crudinnocv.models.User
import com.example.android.crudinnocv.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val service = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
//.create(InnocvApiService::class.java)

interface InnocvApiService {

    @GET("api/User")
    suspend fun getUsers(): List<User>

}

object InnocvApi {
    val retrofitService: InnocvApiService by lazy {
        service.create(InnocvApiService::class.java)
    }
}