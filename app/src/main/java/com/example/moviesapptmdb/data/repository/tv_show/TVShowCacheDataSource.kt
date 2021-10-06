package com.example.moviesapptmdb.data.repository.tv_show

import com.example.moviesapptmdb.data.model.tv_show.TVShow

interface TVShowCacheDataSource {

    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVShowsToCache(movies: List<TVShow>)

}