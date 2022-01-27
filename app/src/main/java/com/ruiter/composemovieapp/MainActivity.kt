package com.ruiter.composemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruiter.composemovieapp.ui.theme.ComposeMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeMovieAppTheme {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "Movies")
            }
        }) {
            content()
        }
    }
}

@Composable
fun MainContent() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Hello")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}