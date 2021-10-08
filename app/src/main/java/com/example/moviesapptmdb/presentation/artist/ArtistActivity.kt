package com.example.moviesapptmdb.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesapptmdb.R
import com.example.moviesapptmdb.databinding.ActivityArtistsBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)

    }
}