package com.example.moviesapptmdb.data.repository.tv_show

import com.example.moviesapptmdb.data.db.TVShowDao
import com.example.moviesapptmdb.data.model.tv_show.TVShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {

    override suspend fun getTVShowsFromDB() = tvShowDao.getAllTVShows()

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.getAllTVShows()
        }
    }
}