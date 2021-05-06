package com.android.jetpacprodua.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.jetpacprodua.databinding.ActivityMenuBinding
import com.android.jetpacprodua.ui.MovieTvAdapter


class MenuActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val sectionsPagerAdapter = MovieTvAdapter(this, supportFragmentManager)
        bind.viewPagerOne.adapter = sectionsPagerAdapter
        bind.tabsOne.setupWithViewPager(bind.viewPagerOne)
        supportActionBar?.elevation = 0f


    }
}