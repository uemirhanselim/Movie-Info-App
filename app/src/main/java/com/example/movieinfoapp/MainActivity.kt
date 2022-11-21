package com.example.movieinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.movieinfoapp.navigation.MovieNavigation
import com.example.movieinfoapp.ui.theme.MovieInfoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
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
fun DefaultPreview() {
    MyApp {

    }
}