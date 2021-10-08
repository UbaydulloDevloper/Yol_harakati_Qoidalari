package com.example.yolqoidalariapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yolqoidalariapp.databinding.FragmentBelgilarShowBinding

class Belgilar_show : Fragment() {
    lateinit var binding: FragmentBelgilarShowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBelgilarShowBinding.inflate(layoutInflater)

        binding.addCharacter.setOnClickListener {
            findNavController().navigate(R.id.action_belgilar_show_to_belgilar_about)
        }

        binding.homeIconClick.setOnClickListener {
            HomeView()
        }

        binding.likeIconClick.setOnClickListener {
            LikeView()
        }


        binding.aboutIconClick.setOnClickListener {
            AboutView()
        }



        return binding.root
    }

    private fun HomeView() {
        binding.title.text = "Yo'l belgilari"
        binding.addCharacter.visibility = View.VISIBLE
        binding.recycleView.visibility = View.VISIBLE
        binding.viewPager.visibility = View.VISIBLE
        binding.homeIconClick.elevation = 10F
        binding.likeIconClick.elevation = 0F
        binding.aboutIconClick.elevation = 0F
    }

    private fun LikeView() {
        binding.title.text = "Yoqtirganlar"
        binding.addCharacter.visibility = View.GONE
        binding.viewPager.visibility = View.GONE
        binding.homeIconClick.elevation = 0F
        binding.likeIconClick.elevation = 10F
        binding.aboutIconClick.elevation = 0F
    }

    private fun AboutView() {
        binding.title.text = "Biz haqimizda"
        binding.addCharacter.visibility = View.GONE
        binding.viewPager.visibility = View.GONE
        binding.recycleView.visibility = View.GONE
        binding.aboutProgrammer.visibility = View.VISIBLE
        binding.homeIconClick.elevation = 0F
        binding.likeIconClick.elevation = 0F
        binding.aboutIconClick.elevation = 10F
    }
}