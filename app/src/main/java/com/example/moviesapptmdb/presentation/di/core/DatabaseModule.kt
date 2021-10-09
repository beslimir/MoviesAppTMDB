package com.example.moviesapptmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.moviesapptmdb.data.db.ArtistDao
import com.example.moviesapptmdb.data.db.MovieDao
import com.example.moviesapptmdb.data.db.RoomDatabaseTMDB
import com.example.moviesapptmdb.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): RoomDatabaseTMDB {
        return Room.databaseBuilder(context, RoomDatabaseTMDB::class.java, "tmdb_database.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(roomDatabaseTMDB: RoomDatabaseTMDB): MovieDao {
        return roomDatabaseTMDB.getMovieDao()
    }

    @Singleton
    @Provides
    fun provideTVShowDao(roomDatabaseTMDB: RoomDatabaseTMDB): TVShowDao {
        return roomDatabaseTMDB.getTVShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(roomDatabaseTMDB: RoomDatabaseTMDB): ArtistDao {
        return roomDatabaseTMDB.getArtistDao()
    }

}