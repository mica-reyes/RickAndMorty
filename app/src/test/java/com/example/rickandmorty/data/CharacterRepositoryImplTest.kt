package com.example.rickandmorty.data


import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharacterListResponse
import com.example.rickandmorty.network.CharacterApiService
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CharacterRepositoryImplTest {

    @Before
    fun setUp() {
    }

    @Test
    fun `characterRepositoryImpl getCharacterList verifyCharacterList`() = runTest {
        val repository = CharacterRepositoryImpl(object : CharacterApiService {
            override suspend fun getCharacterList(): CharacterListResponse {
                return CharacterListResponse(
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

        })
        assertEquals(repository.getCharacterList(), CharacterListResponse(
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
        ))
    }
}