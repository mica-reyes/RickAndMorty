package com.reyesmicaela.rickandmorty.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reyesmicaela.rickandmorty.data.repository.CharacterRepository
import com.reyesmicaela.rickandmorty.data.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    var state: SearchCharacterState by mutableStateOf(SearchCharacterState.Loading)
        private set

    fun filterCharacterByName(name: String) {
        state = SearchCharacterState.Loading
        viewModelScope.launch {
            repository.charactersByNameDb(name).collect {
                state = if (it.isEmpty()) {
                    SearchCharacterState.NotFound
                } else {
                    SearchCharacterState.Success(it.map { characterEntity -> characterEntity.toModel() })
                }
            }
        }
    }
}