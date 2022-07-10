package com.damirmustafin.materialdesign.domain

class AddShopItem(private val shopListRepository: ShopListRepository) {
    fun addShopItem(ShopItem:ShopItem){
        shopListRepository.addShopItem(ShopItem)
    }
}