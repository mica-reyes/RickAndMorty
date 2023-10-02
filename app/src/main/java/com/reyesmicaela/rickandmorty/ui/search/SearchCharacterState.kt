package com.reyesmicaela.rickandmorty.ui.search

import com.reyesmicaela.rickandmorty.model.Character

sealed interface SearchCharacterState {
    data class Success(val characterList: List<Character>) : SearchCharacterState
    object Error : SearchCharacterState
    object HttpError : SearchCharacterState
    object Loading : SearchCharacterState
}