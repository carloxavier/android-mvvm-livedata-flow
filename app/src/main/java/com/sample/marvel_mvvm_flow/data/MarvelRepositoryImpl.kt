package com.sample.marvel_mvvm_flow.data

import com.sample.marvel_mvvm_flow.domain.MarvelRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    val api: MarvelApi
) : MarvelRepository {
    override fun marvelCharacters() = flow {
        val marvelCharacterList = api.fetchMarvelCharacters().data.results
        emit(marvelCharacterList)
    }
}