package com.example.movieinfoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieinfoapp.views.DetailsView
import com.example.movieinfoapp.views.HomeView

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieEnum.HomeView.name) {
        composable(MovieEnum.HomeView.name) {
            HomeView(navController = navController)
        }
        composable(MovieEnum.DetailsView.name + "/{movie}",
        arguments = listOf(navArgument("movie") {type = NavType.StringType})
        ) { backStackEntry ->
            DetailsView(navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}