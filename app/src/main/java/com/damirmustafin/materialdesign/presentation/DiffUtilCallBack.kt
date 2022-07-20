package com.damirmustafin.materialdesign.presentation

import androidx.recyclerview.widget.DiffUtil
import com.damirmustafin.materialdesign.domain.ShopItem

class DiffUtilCallBack(private val newlist:List<ShopItem>,
private val oldlist:List<ShopItem>): DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldlist.size
    }

    override fun getNewListSize(): Int {
   return newlist.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       val newitem = newlist[newItemPosition]
        val olditem = oldlist[oldItemPosition]
        return newitem.id == olditem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newitem = newlist[newItemPosition]
        val olditem = oldlist[oldItemPosition]
        return newitem == olditem
    }


}