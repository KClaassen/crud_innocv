package com.example.android.crudinnocv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.crudinnocv.R
import com.example.android.crudinnocv.models.User

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    var users: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val username = itemView.findViewById<TextView>(R.id.user_name_text)
        private val userBirthday= itemView.findViewById<TextView>(R.id.user_birthday_text)

        fun bind(user: User) {
            username.text = user.name
            userBirthday.text = user.birthdate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

}