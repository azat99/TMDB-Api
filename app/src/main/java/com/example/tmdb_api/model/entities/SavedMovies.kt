package com.example.tmdb_api.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class SavedMovies(

    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String
){
    @PrimaryKey
    var s_id:Int = id
}