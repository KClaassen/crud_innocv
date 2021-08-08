package com.example.android.crudinnocv.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Users (
    @PrimaryKey
    val id: Int, // database entity
    val name: String,
    val birthdate: String
) : Parcelable