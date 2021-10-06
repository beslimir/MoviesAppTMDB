package com.example.moviesapptmdb.data.repository.movie

import com.example.moviesapptmdb.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)

}