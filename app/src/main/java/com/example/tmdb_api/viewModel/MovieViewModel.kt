package com.example.tmdb_api.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdb_api.repositories.Repository
import kotlinx.coroutines.launch

class MovieViewModel(private val repo: Repository): ViewModel() {

    fun movieListFromServer() {
        viewModelScope.launch {
            repo.getMovieListFromServer()
        }
    }

    fun movieListFromDB() = repo.getMovieListFromDB()

}
