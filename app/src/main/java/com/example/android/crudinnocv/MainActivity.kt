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

    private var TAG = "MainActivity"

    private val viewModel: InnocvViewModel by lazy {
        ViewModelProvider(this, InnocvViewModel.Factory(application)).get(
            InnocvViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //binding.viewmodel = viewModel
        with(binding) {
            viewmodel = viewModel
        }

        val adapter = UsersAdapter()
        users_recyclerview.adapter = adapter
        users_recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel.userList.observe(this) {
            adapter.users = it
        }
//        val service = Retrofit.Builder()
//                .baseUrl(Constants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//                .build()
//                .create(InnocvApiService::class.java)
//
//        CoroutineScope(IO).launch {
//            val user = service.getUsers()
//            Log.d(TAG, "${user}")
//        }
    }

}