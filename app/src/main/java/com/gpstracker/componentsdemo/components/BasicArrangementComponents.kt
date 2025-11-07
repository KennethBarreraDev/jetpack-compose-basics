package com.gpstracker.componentsdemo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BasicArrangementComponents(){
    BasicBox()
}

//By default, elements are stacked one above another.
@Composable
fun NoArrangementElement(){
   TextElements()
}

//In a column, elements are positioned vertically
@Composable
fun BasicColumn(){
    Column {
        TextElements()
    }
}

//In a row elements are positioned horizontally
@Composable
fun BasicRow(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextElements()
    }
}


@Composable
fun BasicBox(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

    ){
        TextElements()
    }
}


@Composable
fun TextElements(){
    Text("Sample text")

    Text("Secondary text")
}