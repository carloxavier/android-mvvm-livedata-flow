package com.sample.marvel_mvvm_flow.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMarvelCharactersList @Inject constructor(val repository: MarvelRepository) {
    fun execute(): Flow<Result<List<MarvelCharacter>>> =
        repository.marvelCharacters()
            .map { Result.success(it) }
            .catch { emit(Result.failure(it)) }
}