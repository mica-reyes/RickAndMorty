package com.example.rickandmorty.model

import com.example.rickandmorty.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("results") val results: List<Character>
)
