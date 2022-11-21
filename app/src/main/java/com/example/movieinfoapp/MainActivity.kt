package com.example.movieinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.model.getMovies
import com.example.movieinfoapp.ui.theme.MovieInfoAppTheme
import com.example.movieinfoapp.widgets.MovieRow

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
fun HomeView(movieList: List<Movie> = getMovies()) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "Movies", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    ) {
        LazyColumn() {
            items(items = movieList) {
                MovieRow(movie = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        HomeView()
    }
}