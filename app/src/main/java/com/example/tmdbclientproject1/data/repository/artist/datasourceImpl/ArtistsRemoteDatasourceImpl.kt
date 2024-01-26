package com.example.tmdbclientproject1.data.repository.artist.datasourceImpl

import com.example.tmdbclientproject1.data.api.TMDBService
import com.example.tmdbclientproject1.data.model.artist.ArtistList
import com.example.tmdbclientproject1.data.model.movie.MovieList
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class ArtistsRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}
