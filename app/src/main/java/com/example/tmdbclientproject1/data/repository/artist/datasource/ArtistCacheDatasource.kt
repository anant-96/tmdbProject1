package com.example.tmdbclientproject1.data.repository.artist.datasource

import com.example.tmdbclientproject1.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(artists : List<Artist>)
}
