package com.example.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // columns run vertically
        // rows run horizontally
        setContent {

            val scaffoldState = rememberScaffoldState()

            val scope = rememberCoroutineScope()

            // to handle the state of our input text
            var textFieldState by remember {
                mutableStateOf("")
            }

            // provides the layout that gets along with material design things
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                            Text("Enter your name")
                        },
                        onValueChange = {
                            textFieldState = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        // never launch coroutine directly in a composable
                        // is ok in callbacks such as in here
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                "Hello $textFieldState"
                            )
                        }

                    }) {
                        Text(text = "Pls greet me")
                    }
                }

            }


        }
    }
}
