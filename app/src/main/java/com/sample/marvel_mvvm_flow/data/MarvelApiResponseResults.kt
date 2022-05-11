package com.sample.marvel_mvvm_flow.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarvelApiResponseResults<out T>(
    @field:Json(name = "results") val results: T
)