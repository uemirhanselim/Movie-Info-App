package com.example.movieinfoapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.model.getMovies

@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clickable {
                   onItemClick(movie.title)
        },
        shape = RoundedCornerShape(corner = CornerSize(12.dp),),
        elevation = 6.dp,
        backgroundColor = Color.LightGray
    ) {
        Column() {
            Row(modifier = Modifier.padding(8.dp)) {
                Surface(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp), shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                    elevation =4.dp
                ) {
                    AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(movie.images[0])
                        .crossfade(true)
                        .build(),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Poster")
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(modifier = Modifier.align(Alignment.Top).padding(top = 12.dp)) {
                    Text(text = movie.title, style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("Released Year: ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                            append(movie.released)
                        }
                    })
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("Genres: ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                            append(movie.genre)
                        }
                    })
                }
            }
            AnimatedVisibility(visible = isExpanded,modifier = Modifier.padding(start = 16.dp, end = 8.dp)) {
                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("Plot: ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                        append(movie.plot)
                    }
                })
            }
            Spacer(modifier = Modifier.height(5.dp))

            Icon(imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Arrow Down",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        isExpanded = !isExpanded
                    }
                , tint = Color.DarkGray)
        }
    }
}