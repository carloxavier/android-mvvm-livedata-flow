package com.sample.marvel_mvvm_flow.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sample.marvel_mvvm_flow.domain.GetMarvelCharactersList
import com.sample.marvel_mvvm_flow.domain.MarvelCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersListViewModel @Inject constructor(
    getMarvelCharactersList: GetMarvelCharactersList
) : ViewModel() {
    val charactersList: LiveData<Result<List<MarvelCharacter>>> =
        getMarvelCharactersList.execute().asLiveData()
}