package com.example.android.crudinnocv.repository

import android.util.Log
import com.example.android.crudinnocv.data.InnocvDatabase
import com.example.android.crudinnocv.models.Users
import com.example.android.crudinnocv.network.InnocvApi
import java.lang.Exception


class InnocvRepository(private val database: InnocvDatabase) {

    /**
     *  Users
     */


    suspend fun getUsers() {
        val transactions  = InnocvApi.retrofitService.getUsers()
        var listofUsers: List<Users>? = ArrayList()
        if (listofUsers == null) {
            try {
                listofUsers = transactions
            } catch (e: Exception) {
                e.printStackTrace()
            }
            Log.i("transactions", "$listofUsers")
        }
        database.innocvDao.getUsers()
    }

}