package com.example.composelearning

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearning.ui.theme.ComposeLearningTheme
import kotlinx.coroutines.DisposableHandle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // columns run vertically
        // rows run horizontally

        // a side effect is a block of code that is called after every
        // successful recomposition of the composable which sometimes we don't want


        setContent {

            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()

            Scaffold(scaffoldState = scaffoldState) {

                // syntactic sugar to access the value by automatic
                var counter by remember {
                    mutableStateOf(0)
                }

                if (counter % 5 == 0 && counter != 0) {
                    // this cancels the current coroutine and launches a new one when new
                    // event received
                    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }
                }

                Button(onClick = { counter++ }) {
                    Text(text = "Click me $counter")
                }
            }
        }
    }
}

var i = 0

@Composable
fun MyComposable(backPressedDispatcher: OnBackPressedDispatcher) {
    //i++ this is a side effect and we should avoid it

    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // do something
            }
        }
    }


    // this cleans the used thing after every recomposition
    // to avoid memory leaks
    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher.addCallback(callback)

        onDispose {
            callback.remove()
        }
    }

    // this one is only called in success recomposition
    SideEffect {
        i++
    }


    Button(onClick = {}) {
        Text(text = "Click me")
    }

}
