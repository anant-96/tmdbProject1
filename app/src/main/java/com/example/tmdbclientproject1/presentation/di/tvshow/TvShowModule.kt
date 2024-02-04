package com.example.tmdbclientproject1.presentation.di.tvshow

import com.example.tmdbclientproject1.domain.usecase.GetTvShowsUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateTvShowsUsecase
import com.example.tmdbclientproject1.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUsecase: GetTvShowsUsecase,
        updateTvShowsUsecase: UpdateTvShowsUsecase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUsecase, updateTvShowsUsecase)
    }
}
