package com.example.tmdbclientproject1.presentation.di.core

import com.example.tmdbclientproject1.data.api.TMDBService
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclientproject1.data.repository.artist.datasourceImpl.ArtistsRemoteDatasourceImpl
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistsRemoteDatasourceImpl(tmdbService, apiKey)
    }
}
