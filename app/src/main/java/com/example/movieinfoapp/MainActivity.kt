package com.example.movieinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieinfoapp.ui.theme.MovieInfoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {

            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieInfoAppTheme {
        content()
    }
}

@Composable
fun HomeView() {
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "Movies", textAlign = TextAlign.Right)
            }
        }
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        HomeView()
    }
}