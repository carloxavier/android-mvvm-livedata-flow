package com.sample.marvel_mvvm_flow.data

import com.sample.marvel_mvvm_flow.domain.MarvelCharacter
import retrofit2.http.GET

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun fetchMarvelCharacters(): MarvelApiResponse<List<MarvelCharacter>>
}