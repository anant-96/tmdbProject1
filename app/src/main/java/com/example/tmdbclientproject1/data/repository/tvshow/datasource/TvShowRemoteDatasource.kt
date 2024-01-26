package com.example.tmdbclientproject1.data.repository.tvshow.datasource

import com.example.tmdbclientproject1.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}
