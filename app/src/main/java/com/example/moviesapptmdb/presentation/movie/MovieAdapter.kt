package com.example.moviesapptmdb.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapptmdb.Constants.Companion.IMAGES_URL
import com.example.moviesapptmdb.R
import com.example.moviesapptmdb.data.model.movie.Movie
import com.example.moviesapptmdb.databinding.ListItemBinding

class MovieAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount() = movieList.size
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.tvTitle.text = movie.title
        binding.tvDescription.text = movie.overview
        val posterURL = IMAGES_URL + movie.poster_path

        Glide.with(binding.ivPoster.context)
            .load(posterURL)
            .into(binding.ivPoster)

    }

}