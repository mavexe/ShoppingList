package com.damirmustafin.materialdesign.data

import com.damirmustafin.materialdesign.domain.ShopItem
import com.damirmustafin.materialdesign.domain.ShopItem.Companion.UNDEFINED_ID
import com.damirmustafin.materialdesign.domain.ShopListRepository
import java.lang.RuntimeException

class ShopListRepositoryImpl: ShopListRepository {

    private var shopList = mutableListOf<ShopItem>()

    private var autoIncrementID = 0

    override fun addShopItem(ShopItem: ShopItem) {
        if(ShopItem.id == UNDEFINED_ID){
        ShopItem.id = autoIncrementID++ }
        shopList.add(ShopItem)
    }

    override fun deleteShopItem(ShopItem: ShopItem) {
        shopList.remove(ShopItem)
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

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

}