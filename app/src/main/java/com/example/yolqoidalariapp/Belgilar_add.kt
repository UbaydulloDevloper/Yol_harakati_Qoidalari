package com.example.yolqoidalariapp

import DB.DBHelper
import Models.WayClass
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.yolqoidalariapp.databinding.FragmentBelgilarAddBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class Belgilar_add : Fragment() {
    lateinit var binding: FragmentBelgilarAddBinding
    lateinit var dbHelper: DBHelper
    var absolutePath: String? = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val items = arrayOf("Ogohlantiruvchi", "Imtiyozli", "Ta'qiqlovchi", "Buyuruvchi")
        binding = FragmentBelgilarAddBinding.inflate(layoutInflater)
        dbHelper = DBHelper(container!!.context)
        binding.image.setOnClickListener {
            startActivityForResult(
                Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "image/*"
                },
                1
            )
        }

        binding.spinner.adapter =
            ArrayAdapter(container.context, android.R.layout.simple_spinner_dropdown_item, items)
        binding.saveBtn.setOnClickListener {

            val name = binding.txtName.text.toString()
            val about = binding.txtAbout.text.toString()
            val spiner = binding.spinner.selectedItemPosition

            if (name != "" && about != "" && absolutePath != "") {
                dbHelper.addImage(WayClass(name, absolutePath, about, spiner))
                Toast.makeText(container.context, "Save information's", Toast.LENGTH_SHORT).show()
                binding.txtName.text = null
                binding.txtAbout.text = null
                binding.image.setImageResource(R.drawable.defalte_image)
                findNavController().navigate(R.id.belgilar_show)
            } else {
                Toast.makeText(container.context, "Data is not enough", Toast.LENGTH_SHORT).show()
            }
        }

        binding.backBtn.setOnClickListener {
            childFragmentManager.popBackStack()
        }


        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val uri = data?.data ?: return
            binding.image.setImageURI(uri)
            val format = SimpleDateFormat("yyyyMMdd_hhmmss").format(Date())
            val inputStream = activity?.contentResolver?.openInputStream(uri)
            val file = File(activity?.filesDir, "${format}_image.jpg")
            val fileOutputStream = FileOutputStream(file)
            inputStream?.copyTo(fileOutputStream)
            inputStream?.close()
            fileOutputStream.close()
            absolutePath = file.absolutePath

        }

    }
}