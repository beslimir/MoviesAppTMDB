package com.example.moviesapptmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapptmdb.data.model.artist.Artist
import com.example.moviesapptmdb.data.model.movie.Movie
import com.example.moviesapptmdb.data.model.tv_show.TVShow

@Database(
    entities = [Movie::class, TVShow::class, Artist::class],
    version = 1
)
abstract class RoomDatabaseTMDB: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
    abstract fun getTVShowDao(): TVShowDao
    abstract fun getArtistDao(): ArtistDao

}