package com.reyesmicaela.rickandmorty.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reyesmicaela.rickandmorty.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
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
            state = try {
                CharacterState.Success(repository.getCharacterList())
            } catch (e: IOException) {
                CharacterState.Error
            } catch (e: HttpException) {
                CharacterState.Error
            }
        }
    }
}