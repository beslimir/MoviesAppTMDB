package com.example.moviesapptmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapptmdb.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM Movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM Movie")
    suspend fun getAllMovies(): List<Movie>

}