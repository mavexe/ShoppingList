package com.damirmustafin.materialdesign.domain

class ChangeShopItemUseCase(private val shopItemRepository: ShopListRepository) {
    fun changeShopItem(ShopItem:ShopItem){
        shopItemRepository.changeShopItem(ShopItem)
    }
}