package com.example.tmdbclientproject1.domain.usecase

import com.example.tmdbclientproject1.data.model.tvShow.TvShow
import com.example.tmdbclientproject1.domain.repository.TvShowRepository

class UpdateTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}
