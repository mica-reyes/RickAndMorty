package com.example.rickandmorty.fake

import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import com.reyesmicaela.rickandmorty.data.remote.CharacterApiService
import com.reyesmicaela.rickandmorty.model.Character

class FakeCharacterApiService: CharacterApiService {
    override suspend fun getCharacterList(): CharacterListResponse {
        return FakeDataSource.fakeCharacterListResponse
    }

    override suspend fun getCharacter(id: Int): Character {
        TODO("Not yet implemented")
    }

    override suspend fun filterCharacterByName(name: String): CharacterListResponse {
        TODO("Not yet implemented")
    }
}