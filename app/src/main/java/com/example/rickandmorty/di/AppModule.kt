package com.example.rickandmorty.di

import com.example.rickandmorty.data.CharacterRepository
import com.example.rickandmorty.data.CharacterRepositoryImpl
import com.example.rickandmorty.network.CharacterApiService
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
    fun provideRepository(characterApiService: CharacterApiService): CharacterRepository {
        return CharacterRepositoryImpl(characterApiService)
    }
}