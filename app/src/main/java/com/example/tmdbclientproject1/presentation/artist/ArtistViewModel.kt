package com.example.tmdbclientproject1.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclientproject1.domain.usecase.GetArtistsUsecase
import com.example.tmdbclientproject1.domain.usecase.UpdateArtistsUsecase

class ArtistViewModel(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistsUsecase: UpdateArtistsUsecase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUsecase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUsecase.execute()
        emit(artistList)
    }
}
