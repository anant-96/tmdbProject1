package com.example.tmdbclientproject1.domain.usecase

import com.example.tmdbclientproject1.data.model.artist.Artist
import com.example.tmdbclientproject1.domain.repository.ArtistRepository

class GetArtistsUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}
