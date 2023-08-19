package com.example.rickandmorty.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: Character
) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column() {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(character.image)
                    .crossfade(2000)
                    .build(),
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_connection_error),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
            Text(text = character.name)
        }
    }
}