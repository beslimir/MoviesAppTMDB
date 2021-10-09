package com.example.moviesapptmdb.data.repository.movie

import com.example.moviesapptmdb.Constants.Companion.API_KEY
import com.example.moviesapptmdb.data.api.ServiceTMDB

class MovieRemoteDataSourceImpl(private val serviceTMDB: ServiceTMDB) : MovieRemoteDataSource {

    override suspend fun getMovies() = serviceTMDB.getPopularMovies(API_KEY)

}