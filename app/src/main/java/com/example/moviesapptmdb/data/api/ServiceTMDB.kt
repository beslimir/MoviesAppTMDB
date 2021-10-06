package com.example.moviesapptmdb.data.api


import com.example.moviesapptmdb.data.model.artist.ArtistList
import com.example.moviesapptmdb.data.model.movie.MovieList
import com.example.moviesapptmdb.data.model.tv_show.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/** TMDB API - define suspend functions for API **/

interface ServiceTMDB {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>

}