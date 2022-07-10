package com.damirmustafin.materialdesign.domain

class getShopItemById(private val shopItemRepository: ShopListRepository) {
    fun getShopItem(ShopItemId:Int):ShopItem{
       return shopItemRepository.getShopItem(ShopItemId)
    }
}