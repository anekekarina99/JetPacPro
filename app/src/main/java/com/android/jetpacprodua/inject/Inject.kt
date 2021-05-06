package com.android.jetpacprodua.inject

import com.android.jetpacprodua.data.source.remote.RemoteDataSource
import com.android.jetpacprodua.repository.AllRepository

object Inject {
    fun provideRepository(): AllRepository {

        val remoteDataSource = RemoteDataSource.getInst()

        return AllRepository.getInstance(remoteDataSource)
    }
}