package com.reyesmicaela.rickandmorty.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reyesmicaela.rickandmorty.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: CharacterRepository
) :
    ViewModel() {
    var state: DetailState by mutableStateOf(DetailState.Loading)
        private set
    val characterId: Int = checkNotNull(savedStateHandle["characterId"])

    init {
        getCharacterDetail(characterId)
    }

    fun getCharacterDetail(characterId: Int) {
        viewModelScope.launch {
            state = try {
                DetailState.Success(repository.getCharacter(characterId))
            } catch (e: IOException) {
                DetailState.Error
            } catch (e: HttpException) {
                DetailState.Error
            }
        }
    }
}
