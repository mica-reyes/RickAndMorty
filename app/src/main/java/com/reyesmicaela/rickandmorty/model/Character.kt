package com.reyesmicaela.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: Origin,
    @SerializedName("location") val location: Location
)
