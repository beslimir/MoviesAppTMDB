package com.example.moviesapptmdb.data.repository.tv_show

import com.example.moviesapptmdb.data.model.tv_show.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {

    suspend fun getTVShows(): Response<TVShowList>

}