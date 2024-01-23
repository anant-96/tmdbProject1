package com.example.tmdbclientproject1.domain.repository

import com.example.tmdbclientproject1.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}
