package com.sample.marvel_mvvm_flow.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sample.marvel_mvvm_flow.domain.MarvelCharacter
import com.sample.marvel_mvvm_flow.domain.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersListViewModel @Inject constructor(
    val repository: MarvelRepository
) : ViewModel() {
    val charactersList: LiveData<List<MarvelCharacter>>
        get() = repository.marvelCharacters().asLiveData()
}