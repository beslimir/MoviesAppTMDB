package com.example.moviesapptmdb.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapptmdb.domain.*
import com.example.moviesapptmdb.presentation.tv_show.TVShowViewModel

class ArtistViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
    }
}