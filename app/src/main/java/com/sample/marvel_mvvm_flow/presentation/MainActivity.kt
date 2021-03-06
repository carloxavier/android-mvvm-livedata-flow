package com.sample.marvel_mvvm_flow.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.sample.marvel_mvvm_flow.R
import com.sample.marvel_mvvm_flow.domain.MarvelCharacter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var progressIndicator: CircularProgressIndicator
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

        progressIndicator = findViewById(R.id.progress_indicator)
    }

    private fun observeViewModel() {
        progressIndicator.visibility = View.VISIBLE
        viewModel.charactersList.observe(this) { result ->
            when {
                result.isSuccess -> {
                    result.getOrNull()?.let {
                        marvelCharactersAdapter.submitList(result.getOrDefault(emptyList()))
                    }
                    progressIndicator.visibility = View.GONE
                }
                result.isFailure -> {
                    // TODO
                }
            }
        }
    }

    private fun onClickItem(marvelCharacter: MarvelCharacter) {
        TODO("Not yet implemented")
    }
}