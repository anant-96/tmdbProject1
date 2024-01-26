package com.example.tmdbclientproject1.data.repository.artist

import android.util.Log
import com.example.tmdbclientproject1.data.model.artist.Artist
import com.example.tmdbclientproject1.data.model.artist.ArtistList
import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclientproject1.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclientproject1.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
    ) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
         lateinit var artistList: List<Artist>
         try {
             val response = artistRemoteDatasource.getArtists()
             val body : ArtistList? = response.body()
             if (body != null){
                 artistList = body.results
             }
         } catch (exception : Exception){
             Log.d("MYTAG", exception.message.toString())
         }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        } catch (exception : Exception){
            Log.d("MYTAG", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache() : List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        } catch (exception : Exception){
            Log.d("MYTAG", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}
