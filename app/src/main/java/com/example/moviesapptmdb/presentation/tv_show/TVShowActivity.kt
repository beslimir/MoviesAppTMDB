package com.example.moviesapptmdb.presentation.tv_show

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
import com.example.moviesapptmdb.databinding.ActivityTvShowBinding
import com.example.moviesapptmdb.presentation.di.Injector
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TVShowViewModelFactory
    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var tvShowAdapter: TVShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTVShowSubcomponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TVShowViewModel::class.java)

        initRecyclerView()
        displayTVShows()
    }

    private fun initRecyclerView() {
        binding.rvTVShow.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TVShowAdapter()
        binding.rvTVShow.adapter = tvShowAdapter
    }

    private fun displayTVShows() {
        binding.pbTVShow.visibility = View.VISIBLE

        tvShowViewModel.getTVShows().observe(this, Observer { tvShows ->
            binding.pbTVShow.visibility = View.GONE
            Log.i(Constants.LOG_TAG, tvShows.toString())

            if (tvShows != null) {
                tvShowAdapter.setList(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateTVShows() {
        binding.pbTVShow.visibility = View.VISIBLE

        tvShowViewModel.updateTVShow().observe(this, Observer { tvShows ->
            if (tvShows != null) {
                tvShowAdapter.setList(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            }

            binding.pbTVShow.visibility = View.GONE
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
                updateTVShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}












