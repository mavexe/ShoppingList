package com.damirmustafin.materialdesign.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(ShopItem:ShopItem)

    fun deleteShopItem(ShopItem:ShopItem)

    fun changeShopItem(ShopItem:ShopItem)

    fun getShopItem(ShopItemId:Int):ShopItem

    fun getShopList():LiveData<List<ShopItem>>
}