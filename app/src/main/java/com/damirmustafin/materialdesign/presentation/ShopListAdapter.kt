package com.damirmustafin.materialdesign.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.damirmustafin.materialdesign.R
import com.damirmustafin.materialdesign.domain.ShopItem
import org.w3c.dom.Text
import java.lang.RuntimeException

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        val item = Shoplist[position]
       return if(item.enabled){
        VIEW_TYPE_ENABLED
        }else{
        VIEW_TYPE_DISABLED
        }
    }

    var Shoplist = listOf<ShopItem>()
    set(value){
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when(viewType){
            VIEW_TYPE_ENABLED-> R.layout.note_item
            VIEW_TYPE_DISABLED->R.layout.note_item_disabled
            else -> throw RuntimeException("Unknown viewType $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return Shoplist.size
    }

    class ShopItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val txViewname = itemView.findViewById<TextView>(R.id.txViewName)
        val txViewCount = itemView.findViewById<TextView>(R.id.txViewCount)
    }

    companion object{
        const val VIEW_TYPE_DISABLED = 100
        const val VIEW_TYPE_ENABLED = 101
        const val MAX_POOL_SIZE = 10
    }


}