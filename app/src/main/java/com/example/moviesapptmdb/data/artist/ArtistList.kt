package com.example.moviesapptmdb.data.artist

data class ArtistList(
    val page: Int,
    val results: List<Artist>,
    val total_pages: Int,
    val total_results: Int
)