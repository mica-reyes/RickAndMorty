package com.reyesmicaela.rickandmorty.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.reyesmicaela.rickandmorty.model.Location
import com.reyesmicaela.rickandmorty.model.Origin


@Entity
data class CharacterEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val gender: String,
    @Embedded(prefix = "character_origin_") val origin: Origin,
    @Embedded(prefix = "character_location_") val location: Location
)


//https://developer.android.com/training/data-storage/room/relationships?hl=es-419

