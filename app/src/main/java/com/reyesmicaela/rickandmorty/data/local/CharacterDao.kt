package com.reyesmicaela.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Query("SELECT * from CharacterEntity")
    fun getCharacters(): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterList: List<CharacterEntity>)

    @Query("SELECT * from CharacterEntity WHERE id = :characterId")
    fun getCharacterById(characterId: Int): Flow<CharacterEntity>

    @Query("SELECT * FROM CharacterEntity WHERE name LIKE '%'|| :name || '%' ")
    fun charactersByNameDB(name: String): Flow<List<CharacterEntity>>

}

//https://developer.android.com/training/data-storage/room/accessing-data?hl=es-419#special-return-types  --> Búsquedas paginadas con la biblioteca de Paging