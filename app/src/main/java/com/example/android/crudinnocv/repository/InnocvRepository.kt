package com.example.android.crudinnocv.repository

import com.example.android.crudinnocv.data.InnocvDatabase
import com.example.android.crudinnocv.network.InnocvApi

class InnocvRepository(private val database: InnocvDatabase) {

    /**
     *  Users
     */
    val users = database.innocvDao.getUsers()

    suspend fun getUsers() {
        val users  = InnocvApi.retrofitService.getUsers()
        database.innocvDao.insertAll(users)
    }

}