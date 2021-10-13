package com.example.yolqoidalariapp

import Adapters.MypagerAdapters
import DB.DBHelper
import Models.WayClass
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.yolqoidalariapp.databinding.FragmentBelgilarShowBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.tab_view_item.view.*

class Belgilar_show : Fragment() {
    lateinit var dbHelper: DBHelper
    lateinit var binding: FragmentBelgilarShowBinding
    lateinit var list: ArrayList<WayClass>

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBelgilarShowBinding.inflate(layoutInflater)
        dbHelper = DBHelper(binding.root.context)
        list = ArrayList()
        list.addAll(dbHelper.getAllImage())


        binding.recycleView.adapter = MypagerAdapters(binding.root.context, list)
        binding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

        /*TabClick()*/
        setTab()
        binding.addCharacter.setOnClickListener {
            findNavController().navigate(R.id.action_belgilar_show_to_belgilar_about)
        }

        binding.likeIconClick.setOnClickListener {
            findNavController().navigate(R.id.likeFragment)
        }

        binding.aboutIconClick.setOnClickListener {
            findNavController().navigate(R.id.aboutMe)
        }

        return binding.root
    }


   /* fun TabClick() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.text_item_tab?.setTextColor(R.color.primary_color)
                tab?.customView?.text_item_tab?.setBackgroundColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.text_item_tab?.setTextColor(Color.WHITE)
                tab?.customView?.text_item_tab?.setBackgroundColor(R.drawable.item_rec_row)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }*/

    @SuppressLint("ResourceAsColor")
    private fun setTab() {
        val listtab = ArrayList<String>()
        listtab.add("Ogohlantiruvchi")
        listtab.add("Imtiyozli")
        listtab.add("Ta'qiqlovchi")
        listtab.add("Buyuruvchi")

        TabLayoutMediator(binding.tabLayout, binding.recycleView) { tab, position ->
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_view_item, null, false)
            tab.customView = tabView
            tabView.text_item_tab.text = listtab[position]
            binding.recycleView.setCurrentItem(tab.position, true)
        }.attach()

    }
}