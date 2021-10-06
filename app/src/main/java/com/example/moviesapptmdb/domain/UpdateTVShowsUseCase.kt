package com.example.moviesapptmdb.domain

import com.example.moviesapptmdb.data.model.tv_show.TVShow
import com.example.moviesapptmdb.domain.repository.TVShowRepository

class UpdateTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute(): List<TVShow>? = tvShowRepository.updateTVShows()

}