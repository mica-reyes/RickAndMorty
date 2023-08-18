package com.example.rickandmorty.fake

import com.example.rickandmorty.data.CharacterRepository
import com.example.rickandmorty.model.CharacterListResponse

class FakeCharacterRepository: CharacterRepository {
    override suspend fun getCharacterList(): CharacterListResponse {
        return FakeDataSource.fakeCharacterListResponse
    }

}