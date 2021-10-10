package com.example.moviesapptmdb.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapptmdb.Constants.Companion.IMAGES_URL
import com.example.moviesapptmdb.R
import com.example.moviesapptmdb.data.model.artist.Artist
import com.example.moviesapptmdb.databinding.ListItemBinding

class ArtistAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount() = artistList.size
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(artist: Artist) {
        binding.tvTitle.text = artist.name
        binding.tvDescription.text = artist.popularity.toString()
        val posterURL = IMAGES_URL + artist.profile_path

        Glide.with(binding.ivPoster.context)
            .load(posterURL)
            .into(binding.ivPoster)

    }

}