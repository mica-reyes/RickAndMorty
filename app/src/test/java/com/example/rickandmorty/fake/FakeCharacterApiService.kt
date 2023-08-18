package com.example.rickandmorty.fake

import com.example.rickandmorty.model.CharacterListResponse
import com.example.rickandmorty.network.CharacterApiService

class FakeCharacterApiService: CharacterApiService {
    override suspend fun getCharacterList(): CharacterListResponse {
        return FakeDataSource.fakeCharacterListResponse
    }
}