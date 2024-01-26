package com.example.tmdbclientproject1.data.repository.tvshow.datasource

import com.example.tmdbclientproject1.data.model.tvShow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}
