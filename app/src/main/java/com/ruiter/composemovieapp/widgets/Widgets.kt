package com.ruiter.composemovieapp.widgets

import Movie
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.ruiter.composemovieapp.R
import getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                onItemClick(movie.id.toString())
            },
        elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                elevation = 4.dp
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.posterUrl)
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "Movie image",
                    contentScale = ContentScale.Crop
                )
//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
            }

            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Year: ${movie.year}", style = MaterialTheme.typography.caption)
            }
        }
    }
}