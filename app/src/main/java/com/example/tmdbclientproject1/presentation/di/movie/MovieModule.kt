package com.example.tmdbclientproject1.presentation.di.movie

import com.example.tmdbclientproject1.domain.usecase.GetMoviesUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateMoviesUsecase
import com.example.tmdbclientproject1.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUsecase: GetMoviesUsecase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUsecase, updateMoviesUsecase)
    }
}
