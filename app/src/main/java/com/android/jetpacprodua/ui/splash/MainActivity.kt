package com.android.jetpacprodua.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.android.jetpacprodua.R
import com.android.jetpacprodua.ui.menu.MenuActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)

    }
}