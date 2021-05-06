package com.android.jetpacprodua.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.jetpacprodua.R

class DetailTvActivity : AppCompatActivity() {

    companion object{


        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)
    }
}
