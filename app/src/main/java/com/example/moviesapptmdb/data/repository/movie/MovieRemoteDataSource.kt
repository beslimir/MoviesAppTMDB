package com.example.moviesapptmdb.data.repository.movie

import com.example.moviesapptmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>

}