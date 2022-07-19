package com.damirmustafin.materialdesign.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.damirmustafin.materialdesign.data.ShopListRepositoryImpl
import com.damirmustafin.materialdesign.domain.*

open class MainViewModel(application: Application) : AndroidViewModel(application){
    val shopList: MutableLiveData<List<ShopItem>> by lazy {
        MutableLiveData<List<ShopItem>>()
    }


}