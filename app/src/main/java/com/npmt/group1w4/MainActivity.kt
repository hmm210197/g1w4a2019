package com.npmt.group1w4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.npmt.group1w4.json_model.general
import com.npmt.group1w4.movie_model.movie_adapter
import com.npmt.group1w4.movie_model.movie_item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter : movie_adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        rcMovies.layoutManager = linearLayoutManager

        val jsonString = application.assets.open("movies.json").bufferedReader().use { it.readText() }
        var movies = Gson().fromJson(jsonString,general::class.java)
        var movie = ArrayList<movie_item>()
        movies.results.forEach{ movie?.add(movie_item(it.poster_path,it.title,it.overview,it.release_date,it.vote_average,it.video)) }

        // adapter and view
        adapter = movie_adapter(movie)
        rcMovies.adapter = adapter
    }
}
