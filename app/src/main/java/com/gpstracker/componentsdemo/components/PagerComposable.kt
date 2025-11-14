package com.gpstracker.componentsdemo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun PagerComposable() {
    val pagerState = rememberPagerState(
        initialPage = 2,
        pageCount = {
            10
        })



    val coroutineScope = rememberCoroutineScope()

    //HorizontalElement(pagerState = pagerState, coroutineScope=coroutineScope)
    //VerticalElement(pagerState = pagerState)
    HorizontalElementWithAnimation(pagerState)
}



@Composable
fun HorizontalElementWithAnimation(pagerState: PagerState) {

    val fling = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(10)
    )
    HorizontalPager(
        state = pagerState,
        flingBehavior = fling
        //pageSize = PageSize.Fixed(100.dp)
        ) { page ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer() {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                        alpha = lerp(
                            start = 0.1f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Page $page"
                    )
                    Text(
                        text = "CurrentPage ${pagerState.currentPage}"
                    )
                    Text(
                        text = "OffsetPage ${pagerState.currentPageOffsetFraction}"
                    )

                }
            }
        }
    }
}

@Composable
fun HorizontalElement(pagerState: PagerState, coroutineScope: CoroutineScope) {

    HorizontalPager(state = pagerState) { page ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Page $page"
            )
            Text(
                text = "Current page ${pagerState.currentPage}"
            )
            Text(
                text = "settledPage page ${pagerState.settledPage}"
            )
            Text(
                text = "targetPage page ${pagerState.targetPage}"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(5)
                    }
                }
            ) {
                Text("Jump to page 5")
            }
        }
    }
}


@Composable
fun VerticalElement(pagerState: PagerState) {
    VerticalPager(pagerState) { page ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Page $page"
            )

        }
    }
}