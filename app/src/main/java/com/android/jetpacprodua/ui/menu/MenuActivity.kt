package com.android.jetpacprodua.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.jetpacprodua.databinding.ActivityMenuBinding
import com.android.jetpacprodua.ui.movie.MovieActivity
import com.android.jetpacprodua.ui.tv.TvActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bind.root)

        clickBtnMovie()
        clickBtnTv()
    }

    private fun clickBtnTv() {
        bind.btnTv.setOnClickListener {
            val i = Intent(this, TvActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun clickBtnMovie() {
        bind.btnMovie.setOnClickListener {
            val i = Intent(this, MovieActivity::class.java)
            startActivity(i)
            finish()
        }


    }
}