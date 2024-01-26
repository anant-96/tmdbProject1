package com.example.tmdbclientproject1.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclientproject1.R
import com.example.tmdbclientproject1.databinding.ActivityArtistBinding
import com.example.tmdbclientproject1.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}
