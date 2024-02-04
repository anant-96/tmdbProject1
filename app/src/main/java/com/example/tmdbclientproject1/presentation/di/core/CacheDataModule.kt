package com.example.tmdbclientproject1.presentation.di.core

import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclientproject1.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesMovieCacheDataSource(): MovieCacheDatasource {
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowCacheDataSource(): TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistCacheDataSource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }
}
