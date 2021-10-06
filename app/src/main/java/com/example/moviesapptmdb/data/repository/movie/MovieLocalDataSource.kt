package com.example.moviesapptmdb.data.repository.movie

import com.example.moviesapptmdb.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}