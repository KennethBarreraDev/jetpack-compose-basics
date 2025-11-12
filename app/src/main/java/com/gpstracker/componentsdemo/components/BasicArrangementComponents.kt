package com.gpstracker.componentsdemo.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicArrangementComponents(){
    ConstrainedLayout()
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
        modifier = Modifier.fillMaxSize()){
        TextElements()
    }
}

@Composable
fun TextElements(){
    Text("Sample text")
    Text("Secondary text")
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ConstrainedLayout() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "My constrain values are " +
                    "MinHeight: $minHeight, " +
                    "MaxHeight: $maxHeight, " +
                    "MinWidth: $minWidth, " +
                    "MaxWidth: $maxWidth"
        )
    }
}