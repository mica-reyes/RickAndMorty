package com.example.rickandmorty.data

import com.example.rickandmorty.model.CharacterListResponse

interface CharacterRepository {
    suspend fun getCharacterList(): CharacterListResponse
}