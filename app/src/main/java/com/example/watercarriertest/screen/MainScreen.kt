package com.example.watercarriertest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.watercarriertest.MainActivity.Companion.MAIN_URL
import com.example.watercarriertest.R
import com.example.watercarriertest.retrofit.Data
import com.example.watercarriertest.retrofit.Goods
import com.example.watercarriertest.retrofit.TOVARY
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier
            .padding(5.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.LightGray,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "GOODS",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(goods: Goods?) {
    val tabList = mutableListOf<TOVARY>()
    if (goods != null) for (t in goods.TOVARY) {
        tabList.add(t)
    }
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .padding(
                start = 5.dp,
                end = 5.dp
            )
            .clip(RoundedCornerShape(5.dp))
    ) {
        ScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(pagerState, pos)
                )
            },
            backgroundColor = Color.Gray,
            contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, tovary ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        tovary.NAME?.let { Text(text = it) }
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier
                .weight(0.7f)
                .nestedScroll(remember {
                    object : NestedScrollConnection {
                        override fun onPreScroll(
                            available: Offset,
                            source: NestedScrollSource
                        ): Offset {
                            return if (available.y > 0) Offset.Zero else Offset(
                                x = 0f,
                                y = -scrollState.dispatchRawDelta(-available.y)
                            )
                        }
                    }
                })
        ) { page: Int ->
            ListLazyRow(tabList[page].data)
        }
    }
}

//Slider
@Composable
fun ListLazyRow(items: ArrayList<Data>) {
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items.size) { index ->
            GoodCard(items[index])
        }
    }
}

//
@Composable
fun GoodCard(
    data: Data,
    modifier: Modifier = Modifier,
) {
    val picUrl = data.DETAILPICTURE?.replace("\\", "")
    val imageUrl = "$MAIN_URL$picUrl"
    Column(
        modifier = Modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.background(Color.LightGray),
            contentAlignment = Alignment.TopEnd
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = data.ID.toString(),
                modifier = Modifier
                    .padding(top = 3.dp, end = 8.dp)
            )
            FavoriteButton(modifier = Modifier.padding(12.dp))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = "${data.EXTENDEDPRICE[0].PRICE.toString()} ₽",
                style = TextStyle(fontSize = 20.sp),
                color = Color.Black,
            )
            IconButton(onClick = {
                /*TODO*/
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_shopping_cart),
                    contentDescription = "im4",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color.Red
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
        }
    ) {
        Icon(
            tint = color,
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainCard2() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.LightGray,
            elevation = 50.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "GOODS_2",
                    style = TextStyle(fontSize = 40.sp),
                    color = Color.White
                )
            }
        }
    }
}

