package com.example.moviesapptmdb.data.repository.artist

import com.example.moviesapptmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>

}