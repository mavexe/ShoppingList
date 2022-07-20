package com.damirmustafin.materialdesign.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.damirmustafin.materialdesign.R
import com.damirmustafin.materialdesign.domain.ShopItem
import org.w3c.dom.Text
import java.lang.RuntimeException

class ShopListAdapter: ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallBack()) {

    var onShopItemLongClick: ((ShopItem) -> Unit)? = null
    var onShopItemClick: ((ShopItem)-> Unit)? = null
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
       return if(item.enabled){
        VIEW_TYPE_ENABLED
        }else{
        VIEW_TYPE_DISABLED
        }
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
        val ShopItem = getItem(position)
        holder.itemView.setOnLongClickListener{
            onShopItemLongClick?.invoke(ShopItem)
            true
        }
        holder.itemView.setOnClickListener{
            onShopItemClick?.invoke(ShopItem)
        }
    }



    companion object{
        const val VIEW_TYPE_DISABLED = 100
        const val VIEW_TYPE_ENABLED = 101
        const val MAX_POOL_SIZE = 10
    }


}