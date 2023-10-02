package com.reyesmicaela.rickandmorty.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.ui.components.CharacterListScreen
import com.reyesmicaela.rickandmorty.ui.components.ErrorScreen
import com.reyesmicaela.rickandmorty.ui.components.ShimmerScreen
import com.reyesmicaela.rickandmorty.ui.search.SearchCharacterComponent


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = hiltViewModel(),
    onCharacterClick: (Character) -> Unit
) {
    when (val state = viewModel.state) {
        CharacterState.Error -> ErrorScreen(
            retryAction = viewModel::getAllCharacters,
            modifier = modifier.fillMaxSize()
        )
        CharacterState.Loading -> ShimmerScreen(count = 20)
        is CharacterState.Success -> Column {
            SearchCharacterComponent(onCharacterClick = {
                onCharacterClick(it)
            })
            CharacterListScreen(
                characterList = state.characterListResponse,
                onCharacterClick = {
                    onCharacterClick(it)
                }
            )
        }
    }
}

