package com.reyesmicaela.rickandmorty.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.model.CharacterListResponse

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    characterListResponse: CharacterListResponse,
    onCharacterClick: (Character) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        itemsIndexed(items = characterListResponse.results) { index, character ->
            CharacterCard(
                character = character,
                onCharacterClick = { onCharacterClick(it) }
            )
        }
    }

}
