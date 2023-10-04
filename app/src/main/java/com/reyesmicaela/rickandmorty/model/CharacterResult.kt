package com.reyesmicaela.rickandmorty.model

import com.reyesmicaela.rickandmorty.data.local.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CharacterResult(
    val success: Flow<List<CharacterEntity>> = flowOf(emptyList()),
    val error: Exception? = null
)
