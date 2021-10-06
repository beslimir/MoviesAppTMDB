package com.example.moviesapptmdb.domain.repository

import com.example.moviesapptmdb.data.model.tv_show.TVShow

interface TVShowRepository {

    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?

}