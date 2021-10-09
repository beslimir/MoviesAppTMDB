package com.example.moviesapptmdb.presentation.di.tv_show

import com.example.moviesapptmdb.domain.GetTVShowsUseCase
import com.example.moviesapptmdb.domain.UpdateTVShowsUseCase
import com.example.moviesapptmdb.presentation.tv_show.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {

    @TVShowScope
    @Provides
    fun provideArtistViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(
            getTVShowsUseCase,
            updateTVShowsUseCase
        )
    }

}