package com.example.moviesapptmdb.domain.repository

import com.example.moviesapptmdb.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?

}