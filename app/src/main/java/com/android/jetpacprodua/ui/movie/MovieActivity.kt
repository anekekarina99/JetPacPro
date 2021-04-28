package com.android.jetpacprodua.ui.movie

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.databinding.ActivityMovieBinding
import com.android.jetpacprodua.ui.detail.DetailActivity
import com.android.jetpacprodua.ui.detail.DetailActivity.Companion.EXTRA_DATA
import com.android.jetpacprodua.viewModel.ViewModelFactory

internal class MovieActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMovieBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(bind.root)


        val factory = ViewModelFactory.getInst(this)
        val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        val resultMovie = viewModel.getMovieKorea()
        val adapterM = MovieAdapter()

        bind.rvMovie.layoutManager = LinearLayoutManager(this)
        bind.rvMovie.setHasFixedSize(true)


        resultMovie.observe(this, {
            bind.rvMovie.adapter = adapterM
            adapterM.setMovie(it)
            adapterM.notifyDataSetChanged()
            adapterM.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
                override fun onItemClicked(data: MovieKorea) {
                    showSelectedMovie(data)
                }
            })

        })


    }


    private fun showSelectedMovie(data: MovieKorea) {

        Toast.makeText(this, "Kamu memilih ${data.title}", Toast.LENGTH_SHORT).show()
        val user = MovieKorea(
            data.id,
            data.poster_path,
            data.overview,
            data.title,
            data.vote_average

        )
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra(EXTRA_DATA, user)
        startActivity(i)
        finish()

    }
}