package com.android.jetpacprodua.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.repository.AllRepository

class MovieViewModel(private val allRepository: AllRepository) : ViewModel(){
    fun getMovieKorea() : LiveData<List<MovieKorea>> = allRepository.getMovieKoreaPopular()
}