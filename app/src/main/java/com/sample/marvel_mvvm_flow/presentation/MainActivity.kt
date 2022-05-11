package com.sample.marvel_mvvm_flow.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sample.marvel_mvvm_flow.R
import com.sample.marvel_mvvm_flow.domain.MarvelCharacter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val marvelCharactersAdapter = MarvelCharactersAdapter { marvelCharacter ->
        onClickItem(marvelCharacter)
    }
    val viewModel: MarvelCharactersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        observeViewModel()
    }

    private fun setupView() {
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = marvelCharactersAdapter
    }

    private fun observeViewModel() {
        viewModel.charactersList.observe(this, marvelCharactersAdapter::submitList)
    }

    private fun onClickItem(marvelCharacter: MarvelCharacter) {
        TODO("Not yet implemented")
    }
}