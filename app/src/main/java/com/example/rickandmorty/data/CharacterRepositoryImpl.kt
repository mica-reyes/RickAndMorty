package com.example.rickandmorty.data

import com.example.rickandmorty.network.CharacterApiService
import com.example.rickandmorty.model.CharacterListResponse

class CharacterRepositoryImpl(private val characterApiService: CharacterApiService) :
    CharacterRepository {
    override suspend fun getCharacterList(): CharacterListResponse {
        return characterApiService.getCharacterList()
    }
}