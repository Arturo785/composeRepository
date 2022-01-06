package com.example.composelearning

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearning.ui.theme.ComposeLearningTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // to try to understand better the highOrder functions
        val aaaa = doSomething { num, num2 -> num - num2 }
        val aaaa2 = doSomething { num, num2 -> num + num2 }

        // columns run vertically
        // rows run horizontally
        setContent {
            Column(Modifier.fillMaxSize()) {

                val color = remember {
                    mutableStateOf(Color.Yellow)
                }

                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    color.value = it
                    // every time we touch the box the fun gets called and in here we
                    // receive what was set
                }

                Box(
                    modifier = Modifier
                        .background(color.value)
                        .weight(1f)
                        .fillMaxSize()
                )
            }


        }
    }
}


@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (color: Color) -> Unit) {

    //thanks to this it will hold the value no matter how many times it is called
/*
    val color = remember {
        mutableStateOf(Color.Yellow)
    }
*/

    Box(
        modifier = modifier
            .background(
                Color.Red
            )
            .clickable {
                // sets the value to be received ih the calling lambda
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                    )
                )
            }
    )

}

fun doSomething(action: (num: Int, num2: Int) -> Int): Int {

    var random = Random.nextInt(1, 20)

    // the lambda used receives the value used in here
    return action(random, 4)
}

