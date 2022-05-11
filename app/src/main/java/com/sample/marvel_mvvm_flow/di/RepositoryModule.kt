package com.sample.marvel_mvvm_flow.di

import com.sample.marvel_mvvm_flow.data.MarvelApi
import com.sample.marvel_mvvm_flow.data.MarvelRepositoryImpl
import com.sample.marvel_mvvm_flow.domain.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMarvelRepository(marvelApi: MarvelApi): MarvelRepository = MarvelRepositoryImpl(marvelApi)
}