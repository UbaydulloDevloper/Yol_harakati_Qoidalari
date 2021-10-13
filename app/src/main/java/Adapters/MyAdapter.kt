package Adapters


import DB.DBHelper
import Models.WayClass
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.yolqoidalariapp.Belgilar_about
import com.example.yolqoidalariapp.R
import com.example.yolqoidalariapp.databinding.ItemRecycleViewBinding

class MyAdapter(val context: Context, val list: ArrayList<WayClass>) :
    RecyclerView.Adapter<MyAdapter.Vh>() {
    lateinit var dbHelper: DBHelper

    inner class Vh(var itemRV: ItemRecycleViewBinding) : RecyclerView.ViewHolder(itemRV.root) {
        fun onBind(wayClass: WayClass, position: Int) {
            dbHelper = DBHelper(context)
            itemRV.itemImage.setImageURI(Uri.parse(wayClass.imagePath))
            itemRV.nameImage.text = wayClass.imageName

            when (wayClass.imageLike) {
                1 -> {
                    itemRV.itemLike.setImageResource(R.drawable.ic_heart_1)
                }
                0 -> {
                    itemRV.itemLike.setImageResource(R.drawable.ic_heart__1__1)
                }
            }


            itemRV.itemLike.setOnClickListener {

                if (wayClass.imageLike == 0) {
                    wayClass.imageLike = 1
                    dbHelper.editImage(wayClass)
                } else {
                    wayClass.imageLike = 0
                    dbHelper.editImage(wayClass)

                }
                notifyItemChanged(position)
                // notifyItemRangeRemoved(position, list.size)
            }
            itemRV.itemImage.setOnClickListener {
                var bundle =
                    bundleOf(
                        "key" to wayClass.imageAbout!!,
                        "key1" to wayClass.imageName!!,
                        "key2" to wayClass.imagePath!!
                    )
                it.findNavController().navigate(R.id.belgilar_add, bundle)


            }
            itemRV.nameImage.setOnClickListener {
                var bundle =
                    bundleOf(
                        "key" to wayClass.imageAbout!!,
                        "key1" to wayClass.imageName!!,
                        "key2" to wayClass.imagePath!!
                    )
                it.findNavController().navigate(R.id.belgilar_add, bundle)

            }
            itemRV.deleteBtn.setOnClickListener {
                Toast.makeText(context, "delete Click", Toast.LENGTH_SHORT).show()
            }
            itemRV.editBtn.setOnClickListener {
                Toast.makeText(context, "edit click", Toast.LENGTH_SHORT).show()
            }


        }
    }


    override fun onBindViewHolder(holder: Vh, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemRecycleViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}