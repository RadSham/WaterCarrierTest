package com.example.watercarriertest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import com.example.watercarriertest.retrofit.Goods
import com.example.watercarriertest.retrofit.InitRetrofit
import com.example.watercarriertest.retrofit.MainApi
import com.example.watercarriertest.screen.MainCard
import com.example.watercarriertest.screen.MainCard2
import com.example.watercarriertest.screen.TabLayout
import com.example.watercarriertest.ui.theme.WaterCarrierTestTheme
import com.example.watercarriertest.viewmodel.GoodsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private lateinit var mainApi: MainApi
    private val viewModel: GoodsViewModel by viewModels()
    var goods: Goods? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initRetrofit()
        initViewModel()
    }

    private fun initRetrofit() {
        val inRet = InitRetrofit()
        mainApi = inRet.initRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            if (mainApi.getGoods().code() == 401) {
                Log.d("MyLog", "mainApi.getGoods().code() == 401")
            }
            if (mainApi.getGoods().isSuccessful) {
                val gd = mainApi.getGoods().body()!!
                runOnUiThread {
                    viewModel.setGoods(gd)
                }
            }
        }
    }

    private fun initViewModel() {
        viewModel.mutableGoods.observe(this) { good ->
            goods = good
            setContent()
        }
    }

    private fun setContent() {
        setContent {
            WaterCarrierTestTheme {
                Column {
                    MainCard()
                    if (goods?.status == "Success") TabLayout(goods)
                    MainCard2()
                }
            }
        }
    }

    companion object {
        const val MAIN_URL = "http://szorinvodovoz.tw1.ru"
        const val DATA_PATH_URL = "/newmobile/glavnaya/super_top.php?action=topglav"
    }
}