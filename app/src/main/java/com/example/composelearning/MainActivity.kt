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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // columns run vertically
        // rows run horizontally
        setContent {
            Column(
                modifier = Modifier
                    // the changes are called sequentially
                    .background(Color.Cyan)
                    .fillMaxHeight(.5f)
                    .width(300.dp) // this fills but does not overflow
                    .border(5.dp, Color.Magenta)
                    .padding(5.dp)
                    .border(5.dp, Color.Red)
                    .padding(5.dp)
                    .border(5.dp, Color.Yellow)
                    .padding(5.dp)
                    .border(5.dp, Color.Green)
                    .padding(5.dp)
                //    .requiredWidth(600.dp) this fills and overflows
            ) {
                Text(
                    text = "Hello",
                    modifier = Modifier.clickable {
                        Toast.makeText(
                            this@MainActivity, "clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) // gives space but does not push items pos is x,y
                Spacer(modifier = Modifier.height(50.dp)) // sets a space
                Text(text = "world")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearningTheme {
        Greeting("Android")
    }
}