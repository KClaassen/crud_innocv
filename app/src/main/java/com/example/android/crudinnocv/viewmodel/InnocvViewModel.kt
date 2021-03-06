package com.example.android.crudinnocv.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android.crudinnocv.data.InnocvDatabase
import com.example.android.crudinnocv.repository.InnocvRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class InnocvViewModel(application: Application): ViewModel() {
    private val database = InnocvDatabase.getDatabase(application)
    private val repository = InnocvRepository(database)

    val userList get() = repository.users

    init {
        viewModelScope.launch{
            try {
               getUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                repository.getUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Factory for constructing CountriesListViewModel with parameter
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(InnocvViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return InnocvViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}