package com.example.project4flixsterpart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView

private const val TAG = "DetailActivity"
class DetailActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvOverview: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var releaseDate: TextView
    private lateinit var movieVotes: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvTitle = findViewById(R.id.tvTitle)
        tvOverview = findViewById(R.id.tvOverview)
        ratingBar = findViewById(R.id.rbVoteAverage)
        releaseDate = findViewById(R.id.releaseDate)
        movieVotes = findViewById(R.id.movieVotes)

        val movie = intent.getParcelableExtra<Movie>(MOVIE_EXTRA) as Movie
        Log.i(TAG, "Movie is $movie")
        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        ratingBar.rating = movie.voteAverage.toFloat()
        releaseDate.text = "Release Date: " +movie.releaseDate
        movieVotes.text = "Vote Count: " + movie.voteCount.toString()


    }
}