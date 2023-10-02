package com.reyesmicaela.rickandmorty.data.repository

import com.reyesmicaela.rickandmorty.data.local.CharacterEntity
import com.reyesmicaela.rickandmorty.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getAllCharacters(): Flow<List<CharacterEntity>>
    suspend fun getCharacterListRemote(): List<Character>

    suspend fun getCharacter(id: Int): Character

    fun charactersByNameDb(name: String): Flow<List<CharacterEntity>>
    suspend fun insertCharacterLocally(characterList: List<Character>)

    fun getDbCharacterById(id: Int): Flow<CharacterEntity>
}