package com.example.moviesapptmdb.data.model.artist

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/** Entity for the Artist - I will not use all fields, so I will just comment them **/

@Entity
data class Artist(
//    val adult: Boolean,
//    val gender: Int,
    @PrimaryKey
    val id: Int = 0,
//    val known_for: List<KnownFor>,
//    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
): Serializable