package com.example.rickandmorty.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharacterListResponse

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier, characterListResponse: CharacterListResponse
) {
    LazyVerticalGrid(columns =GridCells.Adaptive(minSize = 150.dp)){
items(characterListResponse.results){
    CharacterCard(character = it)
}
    }
}

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: Character
) {
    Card() {
        Column() {
            AsyncImage(model = character.image, contentDescription = null)
            Text(text = character.name)
        }
    }
}