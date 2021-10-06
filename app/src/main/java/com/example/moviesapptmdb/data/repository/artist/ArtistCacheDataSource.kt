package com.example.moviesapptmdb.data.repository.artist

import com.example.moviesapptmdb.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(movies: List<Artist>)

}