package com.example.rickandmorty.fake

import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import com.reyesmicaela.rickandmorty.network.CharacterApiService

class FakeCharacterApiService: CharacterApiService {
    override suspend fun getCharacterList(): CharacterListResponse {
        return FakeDataSource.fakeCharacterListResponse
    }
}