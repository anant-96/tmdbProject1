package com.example.tmdbclientproject1.domain.repository

import com.example.tmdbclientproject1.data.model.tvShow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}
