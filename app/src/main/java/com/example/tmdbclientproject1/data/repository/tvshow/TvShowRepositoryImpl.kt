package com.example.tmdbclientproject1.data.repository.tvshow

import android.util.Log
import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.model.movie.MovieList
import com.example.tmdbclientproject1.data.model.tvShow.TvShow
import com.example.tmdbclientproject1.data.model.tvShow.TvShowList
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclientproject1.domain.repository.MovieRepository
import com.example.tmdbclientproject1.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
    ) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
         lateinit var tvShowList: List<TvShow>
         try {
             val response = tvShowRemoteDatasource.getTvShows()
             val body : TvShowList? = response.body()
             if (body != null){
                 tvShowList = body.results
             }
         } catch (exception : Exception){
             Log.d("MYTAG", exception.message.toString())
         }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var movieList: List<TvShow>
        try {
            movieList = tvShowLocalDatasource.getTvShowsFromDB()
        } catch (exception : Exception){
            Log.d("MYTAG", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(movieList)
        }
        return movieList
    }

    suspend fun getTvShowsFromCache() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDatasource.getTvShowsFromCache()
        } catch (exception : Exception){
            Log.d("MYTAG", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}
