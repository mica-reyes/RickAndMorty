package com.reyesmicaela.rickandmorty.data

import com.reyesmicaela.rickandmorty.network.CharacterApiService
import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import kotlinx.coroutines.delay

class CharacterRepositoryImpl(private val characterApiService: CharacterApiService) :
    CharacterRepository {
    override suspend fun getCharacterList(): CharacterListResponse {
        delay(800)
        return characterApiService.getCharacterList()
    }
}