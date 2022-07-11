package com.damirmustafin.materialdesign.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.damirmustafin.materialdesign.R
import com.damirmustafin.materialdesign.domain.ShopItem
import org.w3c.dom.Text

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    val list = listOf<ShopItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item_disabled,parent,false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = list[position]
        holder.txViewname.text = shopItem.name
        holder.txViewCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener{
            true
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ShopItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val txViewname = itemView.findViewById<TextView>(R.id.txViewName)
        val txViewCount = itemView.findViewById<TextView>(R.id.txViewCount)
    }


}