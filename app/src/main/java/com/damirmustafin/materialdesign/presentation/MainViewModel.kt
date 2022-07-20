package com.damirmustafin.materialdesign.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.damirmustafin.materialdesign.data.ShopListRepositoryImpl
import com.damirmustafin.materialdesign.domain.*

class MainViewModel(application: Application) : AndroidViewModel(application){
    val shopList: MutableLiveData<List<ShopItem>> by lazy {
        MutableLiveData<List<ShopItem>>()
    }
    private var shopListt = mutableListOf<ShopItem>()

    fun changeEnableState(shopItem: ShopItem){
        shopItem.enabled = !shopItem.enabled
    }

    fun deleteShopItem(ShopItem:ShopItem){
        shopListt.remove(ShopItem)
    }

}