package com.example.tmdbclientproject1.presentation.di.core

import com.example.tmdbclientproject1.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclientproject1.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.tmdbclientproject1.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclientproject1.domain.repository.ArtistRepository
import com.example.tmdbclientproject1.domain.repository.MovieRepository
import com.example.tmdbclientproject1.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource
        )
    }

    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }
}
