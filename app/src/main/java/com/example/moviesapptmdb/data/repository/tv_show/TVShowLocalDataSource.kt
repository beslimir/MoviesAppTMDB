package com.example.moviesapptmdb.data.repository.tv_show

import com.example.moviesapptmdb.data.model.tv_show.TVShow

interface TVShowLocalDataSource {

    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(movies: List<TVShow>)
    suspend fun clearAll()
}