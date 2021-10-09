package com.example.moviesapptmdb.presentation.di.core

import android.content.Context
import com.example.moviesapptmdb.presentation.di.artist.ArtistSubcomponent
import com.example.moviesapptmdb.presentation.di.movie.MovieSubcomponent
import com.example.moviesapptmdb.presentation.di.tv_show.TVShowSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubcomponent::class, TVShowSubcomponent::class, ArtistSubcomponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}