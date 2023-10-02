package com.example.rickandmorty.fake

import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.model.CharacterListResponse
import com.reyesmicaela.rickandmorty.model.Location
import com.reyesmicaela.rickandmorty.model.Origin

object FakeDataSource {
    val fakeCharacterListResponse = CharacterListResponse(
        listOf(
            Character(
                name = "Rick Sanchez",
                id = 1,
                image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                origin = Origin(
                    name = "Earth (C-137)",
                    url = "https://rickandmortyapi.com/api/location/1"
                ),
                status = "Alive",
                gender = "Male",
                species = "Human",
                location = Location(
                    name = "Citadel of Ricks",
                    url = "https://rickandmortyapi.com/api/location/3"
                )
            ),
            Character(
                name = "Morty Smith",
                id = 2,
                image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                origin = Origin(
                    name = "unknown",
                    url = ""
                ),
                status = "Alive",
                gender = "Male",
                species = "Human",
                location = Location(
                    name = "Citadel of Ricks",
                    url = "https://rickandmortyapi.com/api/location/3"
                )
            )
        )
    )
}