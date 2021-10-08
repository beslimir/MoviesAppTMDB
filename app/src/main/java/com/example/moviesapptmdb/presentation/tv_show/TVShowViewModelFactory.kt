package com.example.moviesapptmdb.presentation.tv_show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapptmdb.domain.GetMoviesUseCase
import com.example.moviesapptmdb.domain.GetTVShowsUseCase
import com.example.moviesapptmdb.domain.UpdateMoviesUseCase
import com.example.moviesapptmdb.domain.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
    }
}