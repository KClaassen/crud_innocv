package com.example.android.crudinnocv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.crudinnocv.adapter.UsersAdapter
import com.example.android.crudinnocv.databinding.ActivityMainBinding
import com.example.android.crudinnocv.viewmodel.InnocvViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: InnocvViewModel by lazy {
        val activity = requireNotNull(this) {
        }
        ViewModelProvider(activity, InnocvViewModel.Factory(activity.application)).get(
            InnocvViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewmodel = viewModel

        val adapter = UsersAdapter()
        users_recyclerview.adapter = adapter
        users_recyclerview.layoutManager = LinearLayoutManager(this)

        fetchUsers()
    }

    private fun fetchUsers() {
        viewModel.getUsers()
    }

}