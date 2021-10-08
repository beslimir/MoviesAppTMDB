
package com.example.moviesapptmdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesapptmdb.R
import com.example.moviesapptmdb.databinding.ActivityHomeBinding
import com.example.moviesapptmdb.presentation.artist.ArtistActivity
import com.example.moviesapptmdb.presentation.movie.MovieActivity
import com.example.moviesapptmdb.presentation.tv_show.TVShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        //TODO: Add fragments instead of activities
        binding.bMovies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.bTVShow.setOnClickListener {
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }
        binding.bArtists.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

    }
}