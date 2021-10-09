package com.example.moviesapptmdb.presentation.di

import com.example.moviesapptmdb.presentation.di.artist.ArtistSubcomponent
import com.example.moviesapptmdb.presentation.di.movie.MovieSubcomponent
import com.example.moviesapptmdb.presentation.di.tv_show.TVShowSubcomponent

interface Injector {

    fun createMovieSubcomponent(): MovieSubcomponent
    fun createTVShowSubcomponent(): TVShowSubcomponent
    fun createArtistSubcomponent(): ArtistSubcomponent

}