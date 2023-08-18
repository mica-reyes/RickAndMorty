package com.example.rickandmorty.data


import com.example.rickandmorty.fake.FakeCharacterApiService
import com.example.rickandmorty.fake.FakeDataSource
import com.example.rickandmorty.model.CharacterListResponse
import com.example.rickandmorty.network.CharacterApiService
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CharacterRepositoryImplTest {

    lateinit var fakeCharacterListResponse: CharacterListResponse
    lateinit var fakeApiService: CharacterApiService

    @Before
    fun setUp() {
        fakeCharacterListResponse = FakeDataSource.fakeCharacterListResponse
        fakeApiService = FakeCharacterApiService()
    }

    @Test
    fun `characterRepositoryImpl getCharacterList verifyCharacterList`() = runTest {
        val repository = CharacterRepositoryImpl(fakeApiService)
        assertEquals(repository.getCharacterList(), fakeCharacterListResponse)
    }
}