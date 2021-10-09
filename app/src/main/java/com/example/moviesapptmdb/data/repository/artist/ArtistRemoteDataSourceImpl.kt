package com.example.moviesapptmdb.data.repository.artist

import com.example.moviesapptmdb.Constants.Companion.API_KEY
import com.example.moviesapptmdb.data.api.ServiceTMDB

class ArtistRemoteDataSourceImpl(
    private val serviceTMDB: ServiceTMDB,
    private val apiKey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtists() = serviceTMDB.getPopularArtists(API_KEY)

}