package com.reyesmicaela.rickandmorty.di

import android.app.Application
import androidx.room.Room
import com.reyesmicaela.rickandmorty.data.local.CharacterDao
import com.reyesmicaela.rickandmorty.data.local.RickAndMortyDatabase
import com.reyesmicaela.rickandmorty.data.remote.CharacterApiService
import com.reyesmicaela.rickandmorty.data.repository.CharacterRepository
import com.reyesmicaela.rickandmorty.data.repository.CharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): CharacterApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(ApiService: CharacterApiService, dao: CharacterDao): CharacterRepository {
        return CharacterRepositoryImpl(ApiService, dao)
    }

    @Singleton
    @Provides
    fun provideDatabase(application: Application): RickAndMortyDatabase {
        return Room.databaseBuilder(
            application,
            RickAndMortyDatabase::class.java,
            "rick_and_morty_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideDao(database: RickAndMortyDatabase): CharacterDao {
        return database.CharacterDao()
    }
}