package com.example.tmdbclientproject1.data.repository.tvshow.datasource

import com.example.tmdbclientproject1.data.model.tvShow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}
