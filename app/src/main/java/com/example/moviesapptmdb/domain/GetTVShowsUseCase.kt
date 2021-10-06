package com.example.moviesapptmdb.domain

import com.example.moviesapptmdb.data.model.tv_show.TVShow
import com.example.moviesapptmdb.domain.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute(): List<TVShow>? = tvShowRepository.getTVShows()

}