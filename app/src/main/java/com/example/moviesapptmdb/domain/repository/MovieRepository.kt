package com.example.moviesapptmdb.domain.repository

import com.example.moviesapptmdb.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}