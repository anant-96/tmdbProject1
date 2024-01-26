package com.example.tmdbclientproject1.data.repository.artist.datasource

import com.example.tmdbclientproject1.data.model.artist.Artist

interface ArtistLocalDatasource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists : List<Artist>)
    suspend fun clearAll()
}
