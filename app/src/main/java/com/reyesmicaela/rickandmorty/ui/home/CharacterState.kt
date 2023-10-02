package com.reyesmicaela.rickandmorty.ui.home

import com.reyesmicaela.rickandmorty.model.Character

sealed interface CharacterState {
    data class Success(val characterListResponse:List<Character>) : CharacterState
    object Error : CharacterState
    object Loading : CharacterState

}