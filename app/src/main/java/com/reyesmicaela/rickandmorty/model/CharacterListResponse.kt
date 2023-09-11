package com.reyesmicaela.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("results") val results: List<Character>
)
