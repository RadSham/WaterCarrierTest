package com.example.watercarriertest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.watercarriertest.retrofit.Goods

class GoodsViewModel :ViewModel() {
    val mutableGoods = MutableLiveData<Goods>()

    fun setGoods(goods: Goods) {
        mutableGoods.value = goods
    }
}