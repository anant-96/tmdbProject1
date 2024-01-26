package com.example.tmdbclientproject1.data.repository.movie.datasourceImpl

import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl : MovieCacheDatasource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
       return movieList
    }

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }
}
