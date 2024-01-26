package com.example.tmdbclientproject1.data.repository.movie.datasource

import com.example.tmdbclientproject1.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movie : List<Movie>)
}
