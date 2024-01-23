package com.example.tmdbclientproject1.domain.usecase

import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.domain.repository.MovieRepository

class GetMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}
