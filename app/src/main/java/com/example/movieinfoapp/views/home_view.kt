package com.example.movieinfoapp.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.model.getMovies
import com.example.movieinfoapp.navigation.MovieEnum
import com.example.movieinfoapp.widgets.MovieRow

@Composable
fun HomeView(navController: NavController,movieList: List<Movie> = getMovies()) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp, modifier = Modifier
                .padding(horizontal = 140.dp)
            ) {
                Text(text = "Movies", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center, color = Color.White
                )
            }
        },
        backgroundColor = Color.Black.copy(0.8f)
    ) {
        LazyColumn() {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(MovieEnum.DetailsView.name + "/$movie")
                }
            }
        }
    }
}