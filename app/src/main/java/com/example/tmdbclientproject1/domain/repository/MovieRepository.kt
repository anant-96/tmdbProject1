package com.example.tmdbclientproject1.domain.repository

import com.example.tmdbclientproject1.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}
