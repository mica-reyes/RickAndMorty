package com.example.rickandmorty.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    when (val state = viewModel.state) {
        CharacterState.Error -> ErrorScreen(viewModel::getAllCharacters)
        CharacterState.Loading -> ShimmerScreen()
        is CharacterState.Success -> CharacterListScreen(characterListResponse = state.characterListResponse )
    }
}