package com.example.moviesapptmdb.data.repository.artist

import com.example.moviesapptmdb.data.model.artist.Artist

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()


    override suspend fun getArtistsFromCache() = artistList


    override suspend fun saveArtistsToCache(movies: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(movies)
    }
}