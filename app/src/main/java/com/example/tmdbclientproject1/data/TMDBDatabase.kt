package com.example.tmdbclientproject1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclientproject1.data.model.artist.Artist
import com.example.tmdbclientproject1.data.model.movie.Movie
import com.example.tmdbclientproject1.data.model.tvShow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}
