package com.example.tmdbclientproject1.data.repository.movie.datasourceImpl

import com.example.tmdbclientproject1.data.api.TMDBService
import com.example.tmdbclientproject1.data.model.movie.MovieList
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}
