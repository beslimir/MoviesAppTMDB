package com.example.moviesapptmdb.presentation.artist

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapptmdb.Constants
import com.example.moviesapptmdb.R
import com.example.moviesapptmdb.databinding.ActivityArtistsBinding
import com.example.moviesapptmdb.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistsBinding
    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
        (application as Injector).createArtistSubcomponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        initRecyclerView()
        displayTVShows()

    }

    private fun initRecyclerView() {
        binding.rvArtists.layoutManager = LinearLayoutManager(this)
        artistAdapter = ArtistAdapter()
        binding.rvArtists.adapter = artistAdapter
    }

    private fun displayTVShows() {
        binding.pbArtist.visibility = View.VISIBLE

        artistViewModel.getArtists().observe(this, Observer { artists ->
            binding.pbArtist.visibility = View.GONE
            Log.i(Constants.LOG_TAG, artists.toString())

            if (artists != null) {
                artistAdapter.setList(artists)
                artistAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateArtists() {
        binding.pbArtist.visibility = View.VISIBLE

        artistViewModel.updateArtists().observe(this, Observer { artists ->
            binding.pbArtist.visibility = View.GONE

            if (artists != null) {
                artistAdapter.setList(artists)
                artistAdapter.notifyDataSetChanged()
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actionUpdate -> {
                updateArtists()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}







