package com.example.moviesapptmdb.presentation.di.core

import com.example.moviesapptmdb.data.db.ArtistDao
import com.example.moviesapptmdb.data.db.MovieDao
import com.example.moviesapptmdb.data.db.TVShowDao
import com.example.moviesapptmdb.data.repository.artist.ArtistLocalDataSource
import com.example.moviesapptmdb.data.repository.artist.ArtistLocalDataSourceImpl
import com.example.moviesapptmdb.data.repository.movie.MovieLocalDataSource
import com.example.moviesapptmdb.data.repository.movie.MovieLocalDataSourceImpl
import com.example.moviesapptmdb.data.repository.tv_show.TVShowLocalDataSource
import com.example.moviesapptmdb.data.repository.tv_show.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}