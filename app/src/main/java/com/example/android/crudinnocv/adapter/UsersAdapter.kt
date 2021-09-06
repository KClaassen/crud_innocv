package com.example.android.crudinnocv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.crudinnocv.R
import com.example.android.crudinnocv.models.User
import kotlinx.android.synthetic.main.user_item.view.*

class UsersAdapter(): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    private var users: List<User> = listOf()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.apply {
            user_name_text.text = users[position].name
            user_birthday_text.text = users[position].birthdate
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

}