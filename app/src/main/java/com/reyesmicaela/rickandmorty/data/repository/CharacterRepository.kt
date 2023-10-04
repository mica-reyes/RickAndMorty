package com.reyesmicaela.rickandmorty.data.repository

import com.reyesmicaela.rickandmorty.data.local.CharacterEntity
import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.model.CharacterResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(): CharacterResult

    suspend fun getCharacterListRemote(): List<Character>

    suspend fun getCharacter(id: Int): Character

    fun charactersByNameDb(name: String): Flow<List<CharacterEntity>>

    suspend fun insertCharacterLocally(characterList: List<Character>)

}