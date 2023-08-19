package com.example.rickandmorty.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharacterListResponse
import com.example.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier, characterListResponse: CharacterListResponse
) {
    LazyVerticalGrid(
         columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(items = characterListResponse.results, key = { it.id }) {
            CharacterCard(
                character = it
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListScreenPreview() {
    RickAndMortyTheme {
        val mockData = CharacterListResponse(
            results = List(10) {
                Character(name = "", id = it, image = "")
            }
        )
        CharacterListScreen(characterListResponse = mockData)
    }
}
