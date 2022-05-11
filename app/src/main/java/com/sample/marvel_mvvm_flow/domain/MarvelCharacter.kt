package com.sample.marvel_mvvm_flow.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarvelCharacter(
    @field:Json(name = "name") val name: String
)
