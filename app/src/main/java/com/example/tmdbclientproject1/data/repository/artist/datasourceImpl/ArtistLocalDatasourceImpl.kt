package com.example.tmdbclientproject1.data.repository.artist.datasourceImpl

import com.example.tmdbclientproject1.data.db.ArtistDao
import com.example.tmdbclientproject1.data.db.MovieDao
import com.example.tmdbclientproject1.data.model.artist.Artist
import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclientproject1.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao) : ArtistLocalDatasource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}
