package com.damirmustafin.materialdesign.domain

class DeleteItemUseCase(private val shopItemRepository: ShopListRepository) {
    fun deleteShopItem(ShopItem:ShopItem){
        shopItemRepository.deleteShopItem(ShopItem)
    }
}