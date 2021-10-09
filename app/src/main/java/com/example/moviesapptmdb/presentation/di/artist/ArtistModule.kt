package com.example.moviesapptmdb.presentation.di.artist

import com.example.moviesapptmdb.domain.GetArtistsUseCase
import com.example.moviesapptmdb.domain.UpdateArtistsUseCase
import com.example.moviesapptmdb.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}