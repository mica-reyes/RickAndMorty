package com.example.rickandmorty.network

import com.example.rickandmorty.model.CharacterListResponse
import retrofit2.http.GET

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacterList(): CharacterListResponse
}