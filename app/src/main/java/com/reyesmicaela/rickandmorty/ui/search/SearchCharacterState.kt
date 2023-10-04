package com.reyesmicaela.rickandmorty.ui.search

import com.reyesmicaela.rickandmorty.model.Character

sealed interface SearchCharacterState {
    data class Success(val characterList: List<Character>) : SearchCharacterState
    object NotFound : SearchCharacterState

    object Loading : SearchCharacterState
}