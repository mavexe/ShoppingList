package com.damirmustafin.materialdesign.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.damirmustafin.materialdesign.data.ShopListRepositoryImpl
import com.damirmustafin.materialdesign.domain.*

class MainViewModel: ViewModel(){

    private val repositoryImpl = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopList(repositoryImpl)
    private val ChangeShopItemUseCase = ChangeShopItemUseCase(repositoryImpl)
    private val deleteItem = DeleteItemUseCase(repositoryImpl)

    val shoplist = getShopListUseCase.getShopList()


    fun deleteItem(shopItem: ShopItem){
        deleteItem.deleteShopItem(shopItem)

    }
    fun changeItem(shopItem: ShopItem){
       val newitem = shopItem.copy(enabled = !shopItem.enabled)
        ChangeShopItemUseCase.changeShopItem(newitem)

    }
}