package com.damirmustafin.materialdesign.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
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
    private lateinit var ShopListadapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        Log.d("MyLog", "this main")
        viewModel.shopList.observe(this) {
            ShopListadapter.submitList(it)
        }
    }

    private fun setupRecyclerView(){
       val rvShopList = findViewById<RecyclerView>(R.id.rcViewShopList)
        ShopListadapter = ShopListAdapter()
        with(rvShopList){
            adapter = ShopListadapter
            recycledViewPool
                .setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLED,ShopListAdapter.MAX_POOL_SIZE)
            recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DISABLED,ShopListAdapter.MAX_POOL_SIZE)
        }
        setupOnClicksListeners()
        SetupSwipeListener()
    }

    private fun SetupSwipeListener() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = ShopListadapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rcViewShopList)
    }

    private fun setupOnClicksListeners() {
        ShopListadapter.onShopItemLongClick = {
            viewModel.changeEnableState(it)
        }
        ShopListadapter.onShopItemClick = {
            Log.d("TEST_ADAPTER", "THIS is")

        }
    }

}


