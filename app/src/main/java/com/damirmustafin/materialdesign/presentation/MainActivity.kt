package com.damirmustafin.materialdesign.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.damirmustafin.materialdesign.R
import com.damirmustafin.materialdesign.data.ShopListRepositoryImpl
import com.damirmustafin.materialdesign.databinding.ActivityMainBinding
import com.damirmustafin.materialdesign.databinding.NoteItemBinding
import com.damirmustafin.materialdesign.domain.ChangeShopItemUseCase
import com.damirmustafin.materialdesign.domain.DeleteItemUseCase
import com.damirmustafin.materialdesign.domain.GetShopListUseCase
import com.damirmustafin.materialdesign.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
   private lateinit var  viewModel:MainViewModel
    private lateinit var adapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        Log.d("MyLog", "this main")
        viewModel.shopList.observe(this,{
            adapter.Shoplist = it
        })
    }

    private fun setupRecyclerView(){
       val rvShopList = findViewById<RecyclerView>(R.id.rcViewShopList)
        adapter = ShopListAdapter()
        with(rvShopList){
            adapter = adapter
            recycledViewPool
                .setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLED,ShopListAdapter.MAX_POOL_SIZE)
            recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DISABLED,ShopListAdapter.MAX_POOL_SIZE)
        }
    }



    }


