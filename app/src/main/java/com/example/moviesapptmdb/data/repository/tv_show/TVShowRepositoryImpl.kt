package com.example.moviesapptmdb.data.repository.tv_show

import android.util.Log
import com.example.moviesapptmdb.Constants.Companion.LOG_TAG
import com.example.moviesapptmdb.data.model.tv_show.TVShow
import com.example.moviesapptmdb.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowRepository {

    override suspend fun getTVShows() = getTVShowsFromAPI()

    override suspend fun updateTVShows(): List<TVShow>? {
        val newListOfTVShows = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(newListOfTVShows)
        tvShowCacheDataSource.saveTVShowsToCache(newListOfTVShows)

        return newListOfTVShows
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.results
            }
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        return tvShowList
    }


    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowLocalDataSource.getTVShowsFromDB()
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTVShowsFromCache()
            tvShowLocalDataSource.saveTVShowsToDB(tvShowList)
        }

        return tvShowList
    }


    suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (e: Exception) {
            Log.i(LOG_TAG, "getMoviesFromAPI: ${e.message.toString()}")
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
        }

        return tvShowList
    }


}