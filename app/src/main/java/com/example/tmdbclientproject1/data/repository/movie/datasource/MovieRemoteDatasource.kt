package com.example.tmdbclientproject1.data.repository.movie.datasource

import com.example.tmdbclientproject1.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies() : Response<MovieList>
}
