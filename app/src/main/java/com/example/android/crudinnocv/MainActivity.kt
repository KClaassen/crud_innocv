package com.example.android.crudinnocv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.crudinnocv.databinding.ActivityMainBinding
import com.example.android.crudinnocv.network.InnocvApiService
import com.example.android.crudinnocv.utils.Constants
import com.example.android.crudinnocv.viewmodel.InnocvViewModel
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var TAG = "MainActivity"

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

        //binding.viewmodel = viewModel

//        val adapter = UsersAdapter()
//        users_recyclerview.adapter = adapter
//        users_recyclerview.layoutManager = LinearLayoutManager(this)


        getUsers()
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

    private fun getUsers() {
        viewModel.getUsers()
    }

}