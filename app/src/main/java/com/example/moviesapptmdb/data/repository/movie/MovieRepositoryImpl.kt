package com.example.moviesapptmdb.data.repository.movie

import android.util.Log
import com.example.moviesapptmdb.Constants.Companion.LOG_TAG
import com.example.moviesapptmdb.data.model.movie.Movie
import com.example.moviesapptmdb.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies() = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.results
            }
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        return movieList
    }


    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        if (movieList.isEmpty()) {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }


    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        if (movieList.isEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }


}