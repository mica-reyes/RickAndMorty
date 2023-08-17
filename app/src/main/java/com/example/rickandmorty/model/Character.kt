package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String
)
