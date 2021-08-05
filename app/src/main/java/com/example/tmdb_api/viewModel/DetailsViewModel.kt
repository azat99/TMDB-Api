package com.example.tmdb_api.viewModel

import androidx.lifecycle.ViewModel
import com.example.tmdb_api.model.entities.SavedMovies
import com.example.tmdb_api.repositories.Repository

class DetailsViewModel(private val repo: Repository) : ViewModel() {

    fun movieListFromDB() = repo.getMovieListFromDB()

    fun saveMovieToDB(save : SavedMovies){
        repo.saveMovieToDB(save)
    }
}