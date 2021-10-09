package com.example.moviesapptmdb.presentation.di.core

import com.example.moviesapptmdb.presentation.di.artist.ArtistSubcomponent
import com.example.moviesapptmdb.presentation.di.movie.MovieSubcomponent
import com.example.moviesapptmdb.presentation.di.tv_show.TVShowSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        CacheDataModule::class,
        LocalDataModule::class,
        RemoteDataModule::class,
        DatabaseModule::class,
        DomainRepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubcomponent(): MovieSubcomponent.Factory
    fun TVShowSubcomponent(): TVShowSubcomponent.Factory
    fun artistSubcomponent(): ArtistSubcomponent.Factory

}