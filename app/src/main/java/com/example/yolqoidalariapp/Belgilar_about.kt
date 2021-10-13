package com.example.yolqoidalariapp

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yolqoidalariapp.databinding.FragmentBelgilarAbouteBinding

class Belgilar_about : Fragment() {
    lateinit var binding: FragmentBelgilarAbouteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBelgilarAbouteBinding.inflate(layoutInflater)

        val name = this.arguments?.getString("key1")
        val about = this.arguments?.getString("key")
        val image = this.arguments?.getString("key2")

        binding.aboutTxt.text = about
        binding.title.text = name
        binding.titleAbout.text = name
        binding.image.setImageURI(Uri.parse(image))

        return binding.root
    }

}