package com.example.moviesapptmdb.domain

import com.example.moviesapptmdb.data.model.artist.Artist
import com.example.moviesapptmdb.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}