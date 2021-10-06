package com.example.moviesapptmdb.data.repository.tv_show

import com.example.moviesapptmdb.Constants.Companion.API_KEY
import com.example.moviesapptmdb.data.api.ServiceTMDB

class TVShowRemoteDataSourceImpl(private val serviceTMDB: ServiceTMDB) : TVShowRemoteDataSource {

    override suspend fun getTVShows() = serviceTMDB.getPopularTVShows(API_KEY)

}