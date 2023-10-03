package com.reyesmicaela.rickandmorty.data.repository

import com.reyesmicaela.rickandmorty.data.local.CharacterDao
import com.reyesmicaela.rickandmorty.data.local.CharacterEntity
import com.reyesmicaela.rickandmorty.data.remote.CharacterApiService
import com.reyesmicaela.rickandmorty.data.toEntity
import com.reyesmicaela.rickandmorty.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class  CharacterRepositoryImpl(
    private val characterApiService: CharacterApiService,
    private val dao: CharacterDao
) : CharacterRepository {

    override suspend fun getAllCharacters(): Flow<List<CharacterEntity>> {
        val characterListDb = dao.getCharacters()
        if (characterListDb.first().isEmpty()) {
            val characterListRemote = getCharacterListRemote()
            insertCharacterLocally(characterListRemote)
        }
        return characterListDb
    }

    override suspend fun getCharacterListRemote(): List<Character> {
        return characterApiService.getCharacterList().results
    }

    override suspend fun getCharacter(id: Int): Character {
        return characterApiService.getCharacter(id)
    }

    override fun charactersByNameDb(name: String): Flow<List<CharacterEntity>> {
        return dao.charactersByNameDB(name)
    }

    override suspend fun insertCharacterLocally(characterList: List<Character>) {
        dao.insertCharacter(characterList.map { it.toEntity() })
    }

    override fun getDbCharacterById(id: Int): Flow<CharacterEntity> {
        return dao.getCharacterById(id)
    }

}

