package com.reyesmicaela.rickandmorty.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import com.reyesmicaela.rickandmorty.ui.theme.RickAndMortyTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier, characterListResponse: CharacterListResponse
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        itemsIndexed(items = characterListResponse.results) { index, character ->
            CharacterCard(
                character = character
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
