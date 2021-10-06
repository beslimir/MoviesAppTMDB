package com.example.moviesapptmdb.domain

import com.example.moviesapptmdb.data.model.artist.Artist
import com.example.moviesapptmdb.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()

}