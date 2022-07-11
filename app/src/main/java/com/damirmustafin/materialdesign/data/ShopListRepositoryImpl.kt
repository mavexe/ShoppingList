package com.damirmustafin.materialdesign.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.damirmustafin.materialdesign.domain.ShopItem
import com.damirmustafin.materialdesign.domain.ShopItem.Companion.UNDEFINED_ID
import com.damirmustafin.materialdesign.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {

    private var shopList = mutableListOf<ShopItem>()

    private val shoplistD = MutableLiveData<List<ShopItem>>()
    private var autoIncrementID = 0

    override fun addShopItem(ShopItem: ShopItem) {
        if(ShopItem.id == UNDEFINED_ID){
        ShopItem.id = autoIncrementID++ }
        shopList.add(ShopItem)
        updateList()
    }

    override fun deleteShopItem(ShopItem: ShopItem) {
        shopList.remove(ShopItem)
        updateList()
    }

    override fun changeShopItem(ShopItem: ShopItem) {
        val oldElement = getShopItem(ShopItem.id)
        shopList.remove(oldElement)
        addShopItem(ShopItem)
    }

    override fun getShopItem(ShopItemId: Int): ShopItem {
       return shopList.find { it.id == ShopItemId }
           ?: throw RuntimeException("could not found $ShopItemId")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shoplistD
    }

    private fun updateList(){
        shoplistD.postValue(shopList.toList())
    }
}