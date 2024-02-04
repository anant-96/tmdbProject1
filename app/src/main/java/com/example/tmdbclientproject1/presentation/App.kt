package com.example.tmdbclientproject1.presentation

import android.app.Application
import com.example.tmdbclientproject1.BuildConfig
import com.example.tmdbclientproject1.presentation.di.Injector
import com.example.tmdbclientproject1.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclientproject1.presentation.di.core.AppComponent
import com.example.tmdbclientproject1.presentation.di.core.AppModule
import com.example.tmdbclientproject1.presentation.di.core.DaggerAppComponent
import com.example.tmdbclientproject1.presentation.di.core.NetModule
import com.example.tmdbclientproject1.presentation.di.core.RemoteDataModule
import com.example.tmdbclientproject1.presentation.di.movie.MovieSubComponent
import com.example.tmdbclientproject1.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var  appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}
