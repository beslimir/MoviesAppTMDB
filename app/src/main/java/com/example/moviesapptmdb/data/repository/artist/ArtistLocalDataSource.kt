package com.example.moviesapptmdb.data.repository.artist

import com.example.moviesapptmdb.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(movies: List<Artist>)
    suspend fun clearAll()
}