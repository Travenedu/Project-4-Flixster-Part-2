package com.example.project4flixsterpart2

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

@Parcelize
data class Movie (
    val movieId: Int,
    val voteAverage: Double,
    private val posterPath: String,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val voteCount: Int,
) : Parcelable {
    @IgnoredOnParcel
    val posterImageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"
    companion object{

        fun fromJsonObject(jsonObject: JSONObject): Movie {
            val title = jsonObject.optString("title", "")
            val movieId = jsonObject.optInt("id", 0)
            val posterPath = jsonObject.optString("poster_path", "")
            val overview = jsonObject.optString("overview", "")
            val voteAverage = jsonObject.optDouble("vote_average", 0.0)
            val releaseDate =  jsonObject.optString("release_date", "")
            val voteCount = jsonObject.optInt("vote_count", 0)

            return Movie(movieId, voteAverage, posterPath, title, overview, releaseDate, voteCount)
        }

        fun fromJsonArray(jsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until jsonArray.length()) {
                try {
                    val jsonObject = jsonArray.getJSONObject(i)
                    movies.add(fromJsonObject(jsonObject))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            Log.d("Movie", "fromJSONArray: $movies")
            return movies
        }
    }

}