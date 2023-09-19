package com.reyesmicaela.rickandmorty.data

import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.network.CharacterApiService
import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import kotlinx.coroutines.delay

class CharacterRepositoryImpl(private val characterApiService: CharacterApiService) :
    CharacterRepository {
    override suspend fun getCharacterList(): CharacterListResponse {
        delay(800)
        return characterApiService.getCharacterList()
    }

    override suspend fun getCharacter(id: Int): Character {
        return characterApiService.getCharacter(id)
    }

    override suspend fun filterCharacterByName(name: String): CharacterListResponse {
        return characterApiService.filterCharacterByName(name)
    }
}