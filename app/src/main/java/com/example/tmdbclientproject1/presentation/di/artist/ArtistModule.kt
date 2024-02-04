package com.example.tmdbclientproject1.presentation.di.artist

import com.example.tmdbclientproject1.domain.usecase.GetArtistsUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateArtistsUsecase
import com.example.tmdbclientproject1.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUsecase: GetArtistsUsecase,
        updateArtistsUsecase: UpdateArtistsUsecase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUsecase, updateArtistsUsecase)
    }
}
