package com.example.moviesapptmdb.presentation.tv_show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapptmdb.domain.GetMoviesUseCase
import com.example.moviesapptmdb.domain.GetTVShowsUseCase
import com.example.moviesapptmdb.domain.UpdateMoviesUseCase
import com.example.moviesapptmdb.domain.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModel() {

    fun getTVShows() = liveData {
        val movieList = getTVShowsUseCase.execute()
        emit(movieList)
    }

    fun updateTVShow() = liveData {
        val movieList = updateTVShowsUseCase.execute()
        emit(movieList)
    }


}