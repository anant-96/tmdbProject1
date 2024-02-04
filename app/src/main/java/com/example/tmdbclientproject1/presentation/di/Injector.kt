package com.example.tmdbclientproject1.presentation.di

import com.example.tmdbclientproject1.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclientproject1.presentation.di.movie.MovieSubComponent
import com.example.tmdbclientproject1.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent
}
