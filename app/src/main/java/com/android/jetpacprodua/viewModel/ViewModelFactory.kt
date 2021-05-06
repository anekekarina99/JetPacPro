package com.android.jetpacprodua.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.jetpacprodua.inject.Inject
import com.android.jetpacprodua.repository.AllRepository
import com.android.jetpacprodua.ui.detail.DetailViewModel
import com.android.jetpacprodua.ui.movie.MovieViewModel
import com.android.jetpacprodua.ui.tv.TvViewModel


class ViewModelFactory private constructor(private val factAllRepos: AllRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var inst: ViewModelFactory? = null

        fun getInst(): ViewModelFactory =
            inst ?: synchronized(this)
            {
                ViewModelFactory(Inject.provideRepository()).apply {
                        inst = this
                }
            }
    }

    //@Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) ->{
                MovieViewModel(factAllRepos) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) ->{
                TvViewModel(factAllRepos) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) ->{
                DetailViewModel(factAllRepos) as T
            }
            else ->  throw Throwable("Tidak ada viewModel class di factory yg sesuai :" + modelClass.name)
        }
    }

}
