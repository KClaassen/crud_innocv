package com.example.android.crudinnocv.network

import com.example.android.crudinnocv.models.Users
import com.example.android.crudinnocv.utils.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofitRestClient = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface InnocvApiService {

    @GET("api/User")
    suspend fun getUsers(): List<Users>

}

object InnocvApi {
    val retrofitService: InnocvApiService by lazy {
        retrofitRestClient.create(InnocvApiService::class.java)
    }
}