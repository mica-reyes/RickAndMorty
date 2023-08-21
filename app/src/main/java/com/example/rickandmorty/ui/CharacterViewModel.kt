package com.example.rickandmorty.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {
    var state: CharacterState by mutableStateOf(CharacterState.Loading)
        private set

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            delay(800)
            state = try {
                CharacterState.Success(repository.getCharacterList())
            } catch (e: IOException) {
                CharacterState.Error
            }

        }
    }
}