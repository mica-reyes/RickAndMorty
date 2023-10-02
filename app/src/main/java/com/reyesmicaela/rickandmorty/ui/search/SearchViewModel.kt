package com.reyesmicaela.rickandmorty.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reyesmicaela.rickandmorty.data.repository.CharacterRepository
import com.reyesmicaela.rickandmorty.data.repository.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    var state: SearchCharacterState by mutableStateOf(SearchCharacterState.Loading)
        private set

    fun filterCharacterByName(name: String) {
        state= SearchCharacterState.Loading
        viewModelScope.launch {
            try {
                repository.charactersByNameDb(name).collect{
                    state= SearchCharacterState.Success(it.map { characterEntity -> characterEntity.toModel() })}
            } catch (e: IOException) {
              state=  SearchCharacterState.Error
            }catch (e: HttpException){
            state=    SearchCharacterState.HttpError
            }
        }
    }
}