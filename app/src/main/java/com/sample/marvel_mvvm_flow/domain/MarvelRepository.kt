package com.sample.marvel_mvvm_flow.domain

import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun marvelCharacters(): Flow<List<MarvelCharacter>>
}
