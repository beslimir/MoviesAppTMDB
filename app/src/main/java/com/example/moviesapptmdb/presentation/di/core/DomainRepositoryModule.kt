package com.example.moviesapptmdb.presentation.di.core

import com.example.moviesapptmdb.data.repository.artist.ArtistCacheDataSource
import com.example.moviesapptmdb.data.repository.artist.ArtistLocalDataSource
import com.example.moviesapptmdb.data.repository.artist.ArtistRemoteDataSource
import com.example.moviesapptmdb.data.repository.artist.ArtistRepositoryImpl
import com.example.moviesapptmdb.data.repository.movie.MovieCacheDataSource
import com.example.moviesapptmdb.data.repository.movie.MovieLocalDataSource
import com.example.moviesapptmdb.data.repository.movie.MovieRemoteDataSource
import com.example.moviesapptmdb.data.repository.movie.MovieRepositoryImpl
import com.example.moviesapptmdb.data.repository.tv_show.TVShowCacheDataSource
import com.example.moviesapptmdb.data.repository.tv_show.TVShowLocalDataSource
import com.example.moviesapptmdb.data.repository.tv_show.TVShowRemoteDataSource
import com.example.moviesapptmdb.data.repository.tv_show.TVShowRepositoryImpl
import com.example.moviesapptmdb.domain.repository.ArtistRepository
import com.example.moviesapptmdb.domain.repository.MovieRepository
import com.example.moviesapptmdb.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainRepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowRepository {

        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

}