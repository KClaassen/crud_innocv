package com.example.android.crudinnocv.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class UserItem (
        @PrimaryKey
        @SerializedName("User")
        val useritem: List<User>
) : Parcelable {

    @Parcelize
    data class User(
        val id: Int,
        val name: String,
        val birthdate: String
    ) : Parcelable
}