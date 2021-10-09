package com.example.moviesapptmdb.presentation.di.movie

import com.example.moviesapptmdb.presentation.artist.ArtistActivity
import com.example.moviesapptmdb.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubcomponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubcomponent
    }

}