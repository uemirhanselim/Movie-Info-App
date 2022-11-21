package com.example.movieinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.model.getMovies
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

@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clickable { },
        shape = RoundedCornerShape(corner = CornerSize(12.dp),),
        elevation = 6.dp
    ) {
        Column() {
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "icon", modifier =
                Modifier.size(40.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = movie.title)
                    Text(text = movie.released)
                    Text(text = movie.runtime)
                }
            }

            Icon(imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Arrow Down",
            modifier = Modifier.align(Alignment.CenterHorizontally).clickable {  }
                , tint = Color.DarkGray)
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