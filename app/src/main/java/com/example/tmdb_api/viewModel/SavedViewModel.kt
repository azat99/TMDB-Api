package com.example.tmdb_api.viewModel

import androidx.lifecycle.ViewModel
import com.example.tmdb_api.repositories.Repository

class SavedViewModel(private val repo: Repository): ViewModel() {

    fun getSavedMovieList() = repo.getSavedMovieFromDB()

}