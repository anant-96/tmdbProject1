package com.example.tmdbclientproject1.data.repository.artist.datasourceImpl

import com.example.tmdbclientproject1.data.model.artist.Artist
import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieCacheDatasource

class ArtistCacheDatasourceImpl : ArtistCacheDatasource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}
