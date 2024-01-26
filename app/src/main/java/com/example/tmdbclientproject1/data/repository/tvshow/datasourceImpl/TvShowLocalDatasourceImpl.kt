package com.example.tmdbclientproject1.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientproject1.data.db.MovieDao
import com.example.tmdbclientproject1.data.db.TvShowDao
import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.model.tvShow.TvShow
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDatasource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch{
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}
