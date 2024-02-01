package com.example.tmdbclientproject1.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclientproject1.domain.usecase.GetTvShowsUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModel(
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUsecase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUsecase.execute()
        emit(tvShowList)
    }
}
