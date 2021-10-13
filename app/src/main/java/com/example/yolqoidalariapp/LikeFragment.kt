package com.example.yolqoidalariapp

import Adapters.MyAdapter
import DB.DBHelper
import Models.WayClass
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yolqoidalariapp.databinding.FragmentLikeBinding

class LikeFragment : Fragment() {
    lateinit var binding: FragmentLikeBinding
    lateinit var dbHelper: DBHelper
    lateinit var likeList: ArrayList<WayClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLikeBinding.inflate(layoutInflater)
        dbHelper = DBHelper(container!!.context)
        likeList = ArrayList()
        sortingList()

        binding.recycleView.adapter =
            MyAdapter(container.context, likeList)
        onResume()
        binding.homeIconClick.setOnClickListener {
            findNavController().navigate(R.id.belgilar_show)
        }
        binding.aboutIconClick.setOnClickListener {
            findNavController().navigate(R.id.aboutMe)
        }
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        sortingList()
    }

    fun sortingList() {
        likeList = ArrayList()
        val list = dbHelper.getAllImage()
        for (i in list.indices) {
            if (list[i].imageLike == 1) {
                likeList.add(list[i])
            }
        }
    }
}