package com.example.tmdbclientproject1.presentation.di.core

import com.example.tmdbclientproject1.data.db.ArtistDao
import com.example.tmdbclientproject1.data.db.MovieDao
import com.example.tmdbclientproject1.data.db.TvShowDao
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclientproject1.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDatasource{
        return TvShowLocalDatasourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDao)
    }
}
