package com.example.moviesapptmdb.presentation.di.core

import com.example.moviesapptmdb.data.api.ServiceTMDB
import com.example.moviesapptmdb.data.repository.artist.ArtistRemoteDataSource
import com.example.moviesapptmdb.data.repository.artist.ArtistRemoteDataSourceImpl
import com.example.moviesapptmdb.data.repository.movie.MovieRemoteDataSource
import com.example.moviesapptmdb.data.repository.movie.MovieRemoteDataSourceImpl
import com.example.moviesapptmdb.data.repository.tv_show.TVShowRemoteDataSource
import com.example.moviesapptmdb.data.repository.tv_show.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(serviceTMDB: ServiceTMDB): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(serviceTMDB)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(serviceTMDB: ServiceTMDB): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(serviceTMDB)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(serviceTMDB: ServiceTMDB): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(serviceTMDB)
    }

}