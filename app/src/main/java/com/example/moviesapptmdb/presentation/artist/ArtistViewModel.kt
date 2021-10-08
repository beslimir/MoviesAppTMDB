package com.example.moviesapptmdb.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapptmdb.domain.GetArtistsUseCase
import com.example.moviesapptmdb.domain.GetMoviesUseCase
import com.example.moviesapptmdb.domain.UpdateArtistsUseCase
import com.example.moviesapptmdb.domain.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val movieList = getArtistsUseCase.execute()
        emit(movieList)
    }

    fun updateArtists() = liveData {
        val movieList = updateArtistsUseCase.execute()
        emit(movieList)
    }


}