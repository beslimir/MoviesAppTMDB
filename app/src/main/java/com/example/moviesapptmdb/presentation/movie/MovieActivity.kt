package com.example.moviesapptmdb.presentation.movie

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
import com.example.moviesapptmdb.Constants.Companion.LOG_TAG
import com.example.moviesapptmdb.R
import com.example.moviesapptmdb.databinding.ActivityMovieBinding
import com.example.moviesapptmdb.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubcomponent()
            .inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        initRecyclerView()
        displayPopularMovies()

    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter()
        binding.rvMovies.adapter = movieAdapter
    }

    private fun displayPopularMovies() {
        binding.pbMovie.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i(LOG_TAG, it.toString())
            binding.pbMovie.visibility = View.GONE

            if (it != null) {
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateMovies() {
        binding.pbMovie.visibility = View.VISIBLE

        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it != null) {
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
            }

            binding.pbMovie.visibility = View.GONE
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
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}