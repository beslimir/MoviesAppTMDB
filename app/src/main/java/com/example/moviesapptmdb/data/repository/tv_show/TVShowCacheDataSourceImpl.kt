package com.example.moviesapptmdb.data.repository.tv_show

import com.example.moviesapptmdb.data.model.tv_show.TVShow

class TVShowCacheDataSourceImpl : TVShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache() = tvShowList

    override suspend fun saveTVShowsToCache(movies: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(movies)
    }
}