package com.example.android.crudinnocv.repository

import android.util.Log
import com.example.android.crudinnocv.data.InnocvDatabase
import com.example.android.crudinnocv.models.UserItem
import com.example.android.crudinnocv.network.InnocvApi
import java.lang.Exception


class InnocvRepository(private val database: InnocvDatabase) {

    /**
     *  Users
     */
    val users = database.innocvDao.getUsers()

    suspend fun getUsers() {
        val users  = InnocvApi.retrofitService.getUsers()
        var listofUsers: List<UserItem>? = ArrayList()
        if (listofUsers == null) {
            try {
                listofUsers = users
            } catch (e: Exception) {
                e.printStackTrace()
            }
            Log.i("users", "${listofUsers}")
        }
        database.innocvDao.getUsers()
    }

}