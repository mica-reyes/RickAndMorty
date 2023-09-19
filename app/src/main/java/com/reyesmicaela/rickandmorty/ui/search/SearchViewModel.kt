package com.reyesmicaela.rickandmorty.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reyesmicaela.rickandmorty.data.CharacterRepository
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
            state = try {
                SearchCharacterState.Success(repository.filterCharacterByName(name))
            } catch (e: IOException) {
                SearchCharacterState.Error
            }catch (e: HttpException){
                SearchCharacterState.HttpError
            }
        }
    }
}