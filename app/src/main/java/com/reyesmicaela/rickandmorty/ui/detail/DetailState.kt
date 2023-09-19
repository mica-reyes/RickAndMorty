package com.reyesmicaela.rickandmorty.ui.detail

import com.reyesmicaela.rickandmorty.model.Character


sealed interface DetailState {
    data class Success(val character: Character?) : DetailState
    object Error : DetailState
    object Loading : DetailState

}