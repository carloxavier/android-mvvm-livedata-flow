package com.sample.marvel_mvvm_flow.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.marvel_mvvm_flow.R
import com.sample.marvel_mvvm_flow.domain.MarvelCharacter

class MarvelCharactersAdapter(private val onClick: (MarvelCharacter) -> Unit) :
    ListAdapter<MarvelCharacter, MarvelCharactersAdapter.MarvelCharacterViewHolder>(
        MarvelCharacterDiffCallback
    ) {

    class MarvelCharacterViewHolder(itemView: View, val onClick: (MarvelCharacter) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val currentTextView: TextView = itemView.findViewById(R.id.name)
        private var currentMarvelCharacter: MarvelCharacter? = null

        init {
            itemView.setOnClickListener {
                currentMarvelCharacter?.let {
                    onClick(it)
                }
            }
        }

        fun bind(marvelCharacter: MarvelCharacter) {
            currentMarvelCharacter = marvelCharacter
            currentTextView.text = marvelCharacter.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.character_item,
            parent,
            false
        )
        return MarvelCharacterViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: MarvelCharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object MarvelCharacterDiffCallback : DiffUtil.ItemCallback<MarvelCharacter>() {
    override fun areItemsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem == newItem
    }
}