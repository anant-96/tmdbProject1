package com.example.tmdbclientproject1.presentation.di.core

import com.example.tmdbclientproject1.domain.repository.ArtistRepository
import com.example.tmdbclientproject1.domain.repository.MovieRepository
import com.example.tmdbclientproject1.domain.repository.TvShowRepository
import com.example.tmdbclientproject1.domain.usecase.GetArtistsUsecase
import com.example.tmdbclientproject1.domain.usecase.GetMoviesUsecase
import com.example.tmdbclientproject1.domain.usecase.GetTvShowsUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateArtistsUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateMoviesUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateTvShowsUsecase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUsecase(movieRepository: MovieRepository): GetMoviesUsecase {
        return GetMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUsecase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUsecase(tvShowRepository: TvShowRepository): GetTvShowsUsecase {
        return GetTvShowsUsecase(tvShowRepository)
    }

    @Provides
    fun providesUpdateTvShowUsecase(tvShowRepository: TvShowRepository): UpdateTvShowsUsecase {
        return UpdateTvShowsUsecase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUsecase(artistRepository: ArtistRepository): GetArtistsUsecase {
        return GetArtistsUsecase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUsecase(artistRepository: ArtistRepository): UpdateArtistsUsecase {
        return UpdateArtistsUsecase(artistRepository)
    }
}
