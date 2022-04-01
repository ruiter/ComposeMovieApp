package com.ruiter.composemovieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ruiter.composemovieapp.MovieRow
import com.ruiter.composemovieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Matrix",
        "Star wars",
        "Avangers",
        "Iron Man",
        "Altered Carbon",
        "Spider Man",
        "Captain America",
        "Harry Potter",
        "Life"
    )
) {
    Column() {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    Log.i("ruiter", "MainContent: $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}