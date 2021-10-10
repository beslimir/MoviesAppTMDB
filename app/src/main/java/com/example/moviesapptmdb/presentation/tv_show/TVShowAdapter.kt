package com.example.moviesapptmdb.presentation.tv_show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapptmdb.Constants.Companion.IMAGES_URL
import com.example.moviesapptmdb.R
import com.example.moviesapptmdb.data.model.tv_show.TVShow
import com.example.moviesapptmdb.databinding.ListItemBinding

class TVShowAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    private val tvShowList = ArrayList<TVShow>()

    fun setList(movies: List<TVShow>) {
        tvShowList.clear()
        tvShowList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount() = tvShowList.size
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TVShow) {
        binding.tvTitle.text = tvShow.name
        binding.tvDescription.text = tvShow.overview
        val posterURL = IMAGES_URL + tvShow.poster_path

        Glide.with(binding.ivPoster.context)
            .load(posterURL)
            .into(binding.ivPoster)

    }

}