package com.example.rickandmorty.ui

import com.example.rickandmorty.fake.FakeCharacterRepository
import com.example.rickandmorty.fake.FakeDataSource
import com.example.rickandmorty.rules.TestDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Rule
import org.junit.Test

class CharacterViewModelTest {

    @get :Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun `CharacterViewModel getCharacterList verifyCharacterStateSuccess`() = runTest {
        val state = CharacterViewModel(FakeCharacterRepository()).state
        assertEquals(state, CharacterState.Success(FakeDataSource.fakeCharacterListResponse))

    }
}