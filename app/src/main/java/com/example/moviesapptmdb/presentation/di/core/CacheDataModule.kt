package com.example.moviesapptmdb.presentation.di.core

import com.example.moviesapptmdb.data.repository.artist.ArtistCacheDataSource
import com.example.moviesapptmdb.data.repository.artist.ArtistCacheDataSourceImpl
import com.example.moviesapptmdb.data.repository.movie.MovieCacheDataSource
import com.example.moviesapptmdb.data.repository.movie.MovieCacheDataSourceImpl
import com.example.moviesapptmdb.data.repository.tv_show.TVShowCacheDataSource
import com.example.moviesapptmdb.data.repository.tv_show.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}