package com.android.jetpacprodua.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.jetpacprodua.data.source.local.entity.MovieKorea
import com.android.jetpacprodua.data.source.local.entity.TvKorea
import com.android.jetpacprodua.repository.AllRepository

class TvViewModel(private val allRepository: AllRepository) : ViewModel(){
    fun getTvKorea() : LiveData<List<TvKorea>> = allRepository.getTvKoreaPopular()
}