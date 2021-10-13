package com.example.yolqoidalariapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yolqoidalariapp.databinding.FragmentAboutMeBinding

class AboutMe : Fragment() {
    lateinit var binding: FragmentAboutMeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutMeBinding.inflate(layoutInflater)

        binding.homeIconClick.setOnClickListener {
            findNavController().navigate(R.id.belgilar_show)
        }
        binding.likeIconClick.setOnClickListener {
            findNavController().navigate(R.id.likeFragment)
        }
        return binding.root
    }
}