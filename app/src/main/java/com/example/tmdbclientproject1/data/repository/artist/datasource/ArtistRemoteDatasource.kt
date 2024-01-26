package com.example.tmdbclientproject1.data.repository.artist.datasource

import com.example.tmdbclientproject1.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists() : Response<ArtistList>
}
