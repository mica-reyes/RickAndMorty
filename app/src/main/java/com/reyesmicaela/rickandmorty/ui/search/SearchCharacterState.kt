package com.reyesmicaela.rickandmorty.ui.search

import com.reyesmicaela.rickandmorty.model.CharacterListResponse

sealed interface SearchCharacterState {
    data class Success(val characterListResponse: CharacterListResponse) : SearchCharacterState
    object Error : SearchCharacterState
    object HttpError : SearchCharacterState
    object Loading : SearchCharacterState
}