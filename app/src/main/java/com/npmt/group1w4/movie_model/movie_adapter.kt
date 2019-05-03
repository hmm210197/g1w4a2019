package com.npmt.group1w4.movie_model

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.npmt.group1w4.MovieDetail
import com.npmt.group1w4.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class movie_adapter(private val movies: ArrayList<movie_item>): RecyclerView.Adapter<movie_adapter.movie_holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movie_holder{
        return movie_holder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: movie_holder, position: Int){
        val movie = movies[position]
        holder.bindMovie(movie)
    }

    override fun getItemCount() = movies.size

    class movie_holder(v: View):RecyclerView.ViewHolder(v), View.OnClickListener{
        private var view: View = v
        private var movie: movie_item? = null

        init{v.setOnClickListener(this)}

        override fun onClick(v: View?) {
            val context = itemView.context
            val movieClickIntent = Intent(context,MovieDetail::class.java)
            val b = Bundle()
            b.putParcelable("movie",movie)
            movieClickIntent.putExtras(b)
            context.startActivity(movieClickIntent)
        }

        fun bindMovie(movie:movie_item){
            this.movie = movie
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movie.pic).into(view.movieItemImg)
            view.movieItemTitle.text = movie.title
            view.movieItemOverview.text = movie.overview
            if(movie.video){view.btnPlay.visibility = View.VISIBLE}
        }
    }
}