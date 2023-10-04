package com.reyesmicaela.rickandmorty.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reyesmicaela.rickandmorty.data.repository.CharacterRepository
import com.reyesmicaela.rickandmorty.data.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    var state: CharacterState by mutableStateOf(CharacterState.Loading)
        private set

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            delay(800)
            val result = repository.getAllCharacters()
            if (result.error != null) {
                state = CharacterState.Error
            } else {
                result.success.collect {
                    state = CharacterState.Success(it.toModel())
                }
            }
        }
    }
}