package com.example.tmdbclientproject1.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclientproject1.domain.usecase.GetMoviesUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModel() {

    fun getMovies() =
        liveData { // as the inside code is already run on IO dispatcher we will not gave any thread, so it will run on Main thread
            val movieList = getMoviesUsecase.execute()
            emit(movieList)
        }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }
}
