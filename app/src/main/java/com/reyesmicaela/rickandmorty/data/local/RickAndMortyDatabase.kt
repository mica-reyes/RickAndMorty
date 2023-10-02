package com.reyesmicaela.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

//https://developer.android.com/codelabs/basic-android-kotlin-compose-persisting-data-room?hl=es-419#5
@Database(entities = [CharacterEntity::class], version = 3)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun CharacterDao(): CharacterDao
}