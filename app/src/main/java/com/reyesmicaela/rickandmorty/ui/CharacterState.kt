package com.reyesmicaela.rickandmorty.ui

import com.reyesmicaela.rickandmorty.model.CharacterListResponse

sealed interface CharacterState {
    data class Success(val characterListResponse: CharacterListResponse) : CharacterState
    object Error : CharacterState
    object Loading : CharacterState

}