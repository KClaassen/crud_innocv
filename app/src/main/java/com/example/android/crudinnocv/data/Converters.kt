package com.example.android.crudinnocv.data

import androidx.room.TypeConverter
import com.example.android.crudinnocv.models.UserItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {

    @TypeConverter
    fun fromUsertoJson(value: String): List<UserItem.User>? {
        val listType: Type =
                object : TypeToken<List<UserItem.User>>() {}.type
        return Gson().fromJson<List<UserItem.User>>(value, listType)
    }

    @TypeConverter
    fun JsontoListUser(value: List<UserItem.User>): String? {
        val gson = Gson()
        return gson.toJson(value)
    }
}