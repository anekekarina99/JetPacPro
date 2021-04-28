package com.android.jetpacprodua.ui.tv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.databinding.ActivityTvBinding
import com.android.jetpacprodua.ui.detail.DetailActivity
import com.android.jetpacprodua.ui.detail.DetailActivity.Companion.EXTRA_DATA
import com.android.jetpacprodua.viewModel.ViewModelFactory

class TvActivity : AppCompatActivity() {
    private lateinit var bind: ActivityTvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTvBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val factory = ViewModelFactory.getInst(this)
        val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
        val resultTv = viewModel.getTvKorea()
        val adapterTv = TvAdapter()

        bind.rvTv.layoutManager = LinearLayoutManager(this)
        bind.rvTv.setHasFixedSize(true)
        bind.rvTv.adapter = adapterTv

        resultTv.observe(this, {
            adapterTv.setTv(it)
            adapterTv.notifyDataSetChanged()
            adapterTv.setOnItemClickCallback(object : TvAdapter.OnItemClickCallback {
                override fun onItemClicked(data: TvKorea) {
                    showSelectedTv(data)
                }
            })

        })

    }


    private fun showSelectedTv(data: TvKorea) {

        Toast.makeText(this, "Kamu memilih ${data.name}", Toast.LENGTH_SHORT).show()
        val user = TvKorea(
            data.id,
            data.poster_path,
            data.overview,
            data.name,
            data.vote_average

        )
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra(EXTRA_DATA, user)
        startActivity(i)
        finish()

    }
}