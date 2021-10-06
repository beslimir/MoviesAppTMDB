package com.example.moviesapptmdb.data.tv_show

data class TVShowList(
    val page: Int,
    val results: List<TVShow>,
    val total_pages: Int,
    val total_results: Int
)