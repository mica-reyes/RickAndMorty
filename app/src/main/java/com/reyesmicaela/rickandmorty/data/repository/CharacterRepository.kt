package com.reyesmicaela.rickandmorty.data.repository

import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.model.CharacterListResponse

interface CharacterRepository {
    suspend fun getCharacterList(): CharacterListResponse

    suspend fun getCharacter( id: Int): Character

    suspend fun filterCharacterByName(name: String) : CharacterListResponse
}