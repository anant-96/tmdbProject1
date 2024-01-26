package com.example.tmdbclientproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list1 = listOf("1","2","3","4")
        val list2 = listOf("1","2","3","4")

        val array1 = arrayOf("1","2","3","4")
        val array2 = arrayOf("1","2","3","4")

        println(list1 == list2)
        println(array1 == array2)
    }
}
