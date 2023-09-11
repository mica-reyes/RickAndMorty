package com.reyesmicaela.rickandmorty.network

import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import retrofit2.http.GET

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacterList(): CharacterListResponse
}