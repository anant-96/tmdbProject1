package com.example.tmdbclientproject1.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclientproject1.domain.usecase.GetArtistsUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateArtistsUsecase

class ArtistViewModelFactory(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistsUsecase: UpdateArtistsUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUsecase, updateArtistsUsecase) as T
    }
}
