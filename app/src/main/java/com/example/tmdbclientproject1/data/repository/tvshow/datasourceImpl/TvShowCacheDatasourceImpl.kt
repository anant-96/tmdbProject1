package com.example.tmdbclientproject1.data.repository.tvshow.datasourceImpl

import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.model.tvShow.TvShow
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl : TvShowCacheDatasource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}
