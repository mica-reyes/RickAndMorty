package com.example.rickandmorty.ui

import com.example.rickandmorty.model.CharacterListResponse

sealed interface CharacterState {
    data class Success(val characterListResponse: CharacterListResponse) : CharacterState
    object Error : CharacterState
    object Loading : CharacterState

}