package com.reyesmicaela.rickandmorty.data

import com.reyesmicaela.rickandmorty.model.CharacterListResponse

interface CharacterRepository {
    suspend fun getCharacterList(): CharacterListResponse
}