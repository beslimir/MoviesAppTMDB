package com.example.moviesapptmdb.data.repository.artist

import android.util.Log
import com.example.moviesapptmdb.Constants.Companion.LOG_TAG
import com.example.moviesapptmdb.data.model.artist.Artist
import com.example.moviesapptmdb.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists() = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.results
            }
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        return artistList
    }


    suspend fun getMoviesFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        if (artistList.isEmpty()) {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }


    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        if (artistList.isEmpty()) {
            artistList = getMoviesFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }


}