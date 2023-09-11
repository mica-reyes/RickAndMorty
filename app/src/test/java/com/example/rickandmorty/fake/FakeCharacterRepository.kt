package com.example.rickandmorty.fake

import com.reyesmicaela.rickandmorty.data.CharacterRepository
import com.reyesmicaela.rickandmorty.model.CharacterListResponse

class FakeCharacterRepository: CharacterRepository {
    override suspend fun getCharacterList(): CharacterListResponse {
        return FakeDataSource.fakeCharacterListResponse
    }

}