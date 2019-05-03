package com.npmt.group1w4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.npmt.group1w4.movie_model.movie_item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity() {

    private lateinit var selectedMovie: movie_item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val b = getIntent().getExtras()
        selectedMovie = b.getParcelable("movie")

        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+selectedMovie.pic).into(imagePoster)
        TitleDetail.text = selectedMovie.title
        ReleaseDay.text = "Release day: "+selectedMovie.releaseDay
        rating.rating = selectedMovie.rating/2
        DetailDecription.text = selectedMovie.overview
    }
}
