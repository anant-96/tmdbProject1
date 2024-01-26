package com.example.tmdbclientproject1.data.repository.movie

import android.util.Log
import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.model.movie.MovieList
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclientproject1.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
    ) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
         lateinit var movieList: List<Movie>
         try {
             val response = movieRemoteDatasource.getMovies()
             val body : MovieList? = response.body()
             if (body != null){
                 movieList = body.results
             }
         } catch (exception : Exception){
             Log.d("MYTAG", exception.message.toString())
         }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        } catch (exception : Exception){
            Log.d("MYTAG", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDatasource.getMoviesFromCache()
        } catch (exception : Exception){
            Log.d("MYTAG", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}
