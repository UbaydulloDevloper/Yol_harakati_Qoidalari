package com.example.yolqoidalariapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.yolqoidalariapp.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val c = Runnable {
            findNavController(R.id.my_host).navigate(R.id.action_home_yol_Harakat_to_belgilar_show)
        }
        val hend = Handler()
        hend.postDelayed(c, 2000)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_host).navigateUp()
    }
}