package com.sample.marvel_mvvm_flow.data

import com.sample.marvel_mvvm_flow.domain.MarvelCharacter
import com.sample.marvel_mvvm_flow.domain.MarvelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    val api: MarvelApi
) : MarvelRepository {
    override fun marvelCharacters(): Flow<List<MarvelCharacter>> = flow {
        val marvelCharacterList = api.fetchMarvelCharacters().data.results
        emit(marvelCharacterList)
    }.flowOn(Dispatchers.IO)
}