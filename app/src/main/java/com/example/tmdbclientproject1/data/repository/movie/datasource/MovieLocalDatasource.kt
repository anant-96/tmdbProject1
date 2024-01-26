package com.example.tmdbclientproject1.data.repository.movie.datasource

import com.example.tmdbclientproject1.data.model.movie.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}
