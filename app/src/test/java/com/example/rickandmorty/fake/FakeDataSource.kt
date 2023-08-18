package com.example.rickandmorty.fake

import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharacterListResponse

object FakeDataSource {
val fakeCharacterListResponse= CharacterListResponse(
    listOf(
        Character(
            name = "Rick Sanchez",
            id = 1,
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        ),
        Character(
            name = "Morty Smith",
            id = 2,
            image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
        )
    )
)
}