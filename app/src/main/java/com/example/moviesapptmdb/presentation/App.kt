package com.example.moviesapptmdb.presentation

import android.app.Application
import com.example.moviesapptmdb.Constants.Companion.API_KEY
import com.example.moviesapptmdb.Constants.Companion.BASE_URL
import com.example.moviesapptmdb.presentation.di.Injector
import com.example.moviesapptmdb.presentation.di.artist.ArtistSubcomponent
import com.example.moviesapptmdb.presentation.di.core.*
import com.example.moviesapptmdb.presentation.di.movie.MovieSubcomponent
import com.example.moviesapptmdb.presentation.di.tv_show.TVShowSubcomponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        //just modules with constructor parameters
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BASE_URL))
            .build()

    }

    override fun createMovieSubcomponent(): MovieSubcomponent {
        return appComponent.movieSubcomponent().create()
    }

    override fun createTVShowSubcomponent(): TVShowSubcomponent {
        return appComponent.TVShowSubcomponent().create()
    }

    override fun createArtistSubcomponent(): ArtistSubcomponent {
        return appComponent.artistSubcomponent().create()
    }
}