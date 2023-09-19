package com.reyesmicaela.rickandmorty.network

import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacterList(): CharacterListResponse

    @GET("character/{characterId}")
    suspend fun getCharacter(@Path("characterId") id: Int): Character

    //https://rickandmortyapi.com/api/character/?name=rick
    //devuelve un CharacterList o 404 not found
    @GET("character/")
    suspend fun filterCharacterByName(@Query("name") name: String) : CharacterListResponse
}