package com.example.tmdbclientproject1.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclientproject1.R
import com.example.tmdbclientproject1.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_movie)
    }
}
