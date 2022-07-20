package com.damirmustafin.materialdesign.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.damirmustafin.materialdesign.R

class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val txViewname = itemView.findViewById<TextView>(R.id.txViewName)
    val txViewCount = itemView.findViewById<TextView>(R.id.txViewCount)
}