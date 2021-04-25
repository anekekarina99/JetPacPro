package com.android.jetpacprodua.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.jetpacprodua.R

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}