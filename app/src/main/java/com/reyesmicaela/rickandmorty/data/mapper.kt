package com.reyesmicaela.rickandmorty.data

import com.reyesmicaela.rickandmorty.data.local.CharacterEntity
import com.reyesmicaela.rickandmorty.model.Character

fun Character.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        gender = this.gender,
        image = this.image,
        location = this.location,
        origin = this.origin,
        species = this.species,
        status = this.status
    )
}

fun CharacterEntity.toModel(): Character {
    return Character(
        id = this.id,
        name = this.name,
        gender = this.gender,
        image = this.image,
        location = this.location,
        origin = this.origin,
        species = this.species,
        status = this.status
    )
}