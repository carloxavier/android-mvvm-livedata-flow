package com.sample.marvel_mvvm_flow.di

import com.sample.marvel_mvvm_flow.domain.MarvelRepository
import com.sample.marvel_mvvm_flow.domain.GetMarvelCharactersList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UsecaseModule {
    @Provides
    @Singleton
    fun providesGetMarvelCharactersList(repository: MarvelRepository) = GetMarvelCharactersList(repository)
}