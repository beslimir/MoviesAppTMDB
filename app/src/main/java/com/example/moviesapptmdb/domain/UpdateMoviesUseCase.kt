package com.example.moviesapptmdb.domain

import com.example.moviesapptmdb.data.model.movie.Movie
import com.example.moviesapptmdb.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}