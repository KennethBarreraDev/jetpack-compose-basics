package com.gpstracker.componentsdemo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ModifierLayoutBox(){
    RowsWithWeights()
}

@Composable
fun CustomModifierBox(name: String){
    //Modifiers allow us to configure different built-in styles in our Android app.
    Column(
        modifier = Modifier
            .background(color = Color.Blue)
            .padding(24.dp)
            .fillMaxWidth()) {
        Text(text = "Hello")
        Text(text = name)
    }
}

@Composable
fun ComposableModifiersCard(){
    //Required size allow us to make a component even bigger than the constraints of its parent.
    Row (
        modifier = Modifier.background(color = Color.Green).size(width = 400.dp, height = 400.dp)){
        Box(
            modifier = Modifier.background(color = Color.Blue).requiredSize(width = 200.dp, height = 500.dp)
        ){
            Text("Modifier element")
        }
    }
}

@Composable
fun OffsetComposable(){
    //Offset an element's position relative to its default position without changing its dimensions.
    Row {
        Column(modifier = Modifier.padding(top = 40.dp).background(color = Color.Blue)) {
            Text("Username")
            Text("Secondary text", modifier = Modifier.offset(x = 20.dp))
        }
    }
}

@Composable
fun RowsWithWeights(){
    Row(
        modifier = Modifier.fillMaxWidth().height(400.dp)
    ) {
        Box(modifier = Modifier.background(color = Color.Red).weight(1f).fillMaxHeight()){
        }
        Box(modifier = Modifier.background(color = Color.Blue).weight(2f).fillMaxHeight()){
        }
        Box(modifier = Modifier.background(color = Color.Green).weight(1f).fillMaxHeight()){
        }
    }
}

