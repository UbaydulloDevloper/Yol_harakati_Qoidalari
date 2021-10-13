package Adapters

import Models.WayClass
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.yolqoidalariapp.R
import com.example.yolqoidalariapp.databinding.RecycleItemBinding
import kotlinx.android.synthetic.main.recycle_item.view.*

class MypagerAdapters(var context: Context, private val arraylist: ArrayList<WayClass>) :
    RecyclerView.Adapter<MypagerAdapters.Vh>() {
    lateinit var listpo: ArrayList<WayClass>

    inner class Vh(var itemRV: RecycleItemBinding) : RecyclerView.ViewHolder(itemRV.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

        listpo = ArrayList()
        when (position) {
            0 -> {
                for (positions in arraylist.indices) {
                    if (arraylist[positions].imageTur == 0) {
                        listpo.add(arraylist[positions])
                    }
                }
            }
            1 -> {
                for (positions in arraylist.indices) {
                    if (arraylist[positions].imageTur == 1) {
                        listpo.add(arraylist[positions])
                    }
                }
            }
            2 -> {
                for (positions in arraylist.indices) {
                    if (arraylist[positions].imageTur == 2) {
                        listpo.add(arraylist[positions])
                    }
                }
            }
            3 -> {
                for (positions in arraylist.indices) {
                    if (arraylist[positions].imageTur == 3) {
                        listpo.add(arraylist[positions])
                    }
                }
            }
        }
        holder.itemRV.recycleItemCustom.adapter = MyAdapter(context,listpo)
    }

    override fun getItemCount(): Int = arraylist.size
}