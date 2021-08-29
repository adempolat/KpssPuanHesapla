package com.adempolat.kpsspuanhesapla.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adempolat.kpsspuanhesapla.ItemMenu
import com.adempolat.kpsspuanhesapla.R
import kotlinx.android.synthetic.main.item_menu.view.*

class MyAdapter(private val list: MutableList<ItemMenu>?,
                private val listener: (ItemMenu) -> Unit):
        RecyclerView.Adapter<MyAdapter.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder = MyHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
    )

    override fun getItemCount(): Int = list?.size!!

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        list?.get(position)?.let{
            holder.bindItem(it, listener)
        }
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(data: ItemMenu,
                     listener:(ItemMenu)->Unit){
            itemView.img_icon.setImageResource(data.icon!!)
            itemView.title.text = data.title

            itemView.setOnClickListener{
                listener(data)
            }
        }
    }
}