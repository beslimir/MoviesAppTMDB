package com.example.moviesapptmdb.presentation.di.core

import com.example.moviesapptmdb.domain.*
import com.example.moviesapptmdb.domain.repository.ArtistRepository
import com.example.moviesapptmdb.domain.repository.MovieRepository
import com.example.moviesapptmdb.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTVShowsUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase {
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowsUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase {
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

}