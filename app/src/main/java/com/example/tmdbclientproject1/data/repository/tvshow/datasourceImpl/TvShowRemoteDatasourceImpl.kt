package com.example.tmdbclientproject1.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientproject1.data.api.TMDBService
import com.example.tmdbclientproject1.data.model.movie.MovieList
import com.example.tmdbclientproject1.data.model.tvShow.TvShowList
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}
