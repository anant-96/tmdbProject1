package com.example.tmdbclientproject1.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclientproject1.R
import com.example.tmdbclientproject1.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}
