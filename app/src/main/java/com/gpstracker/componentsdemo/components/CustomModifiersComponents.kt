package com.gpstracker.componentsdemo.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

//Modifier factory, it generate a modifier chaining a list ot bult-in modifiers
fun Modifier.myBackground(color: Color) = padding(10.dp).background(color = Color.Red)

@Composable
fun Modifier.fade(enable: Boolean): Modifier{
    val alpha by animateFloatAsState(if(enable) 0.5f else 1.0f)
    return this then Modifier.graphicsLayer{this.alpha=alpha}
}


@Composable
fun CustomModifiersComponents(){
    FactoryModifierExample()
}


@Composable
fun FactoryModifierExample(){
    Text("Custom modifier example", modifier = Modifier.myBackground(Color.Red).fade(enable = true))
}