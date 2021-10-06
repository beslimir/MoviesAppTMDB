package com.example.moviesapptmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapptmdb.data.model.tv_show.TVShow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows: List<TVShow>)

    @Query("DELETE FROM TVShow")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM TVShow")
    suspend fun getAllTVShows(): List<TVShow>

}