package com.example.tmdb_api.repositories

import androidx.lifecycle.LiveData
import com.example.tmdb_api.model.entities.Result
import com.example.tmdb_api.model.entities.SavedMovies

interface Repository {

    suspend fun getMovieListFromServer()
    fun getMovieListFromDB(): LiveData<List<Result>>

    fun saveMovieToDB(likedData: SavedMovies)
    fun getSavedMovieFromDB(): LiveData<List<SavedMovies>>


}