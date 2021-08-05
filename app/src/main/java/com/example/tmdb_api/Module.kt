package com.example.tmdb_api

import com.example.tmdb_api.viewModel.MovieViewModel
import com.example.tmdb_api.model.api.ApiService
import com.example.tmdb_api.model.db.MovieDatabase
import com.example.tmdb_api.repositories.Repository
import com.example.tmdb_api.repositories.RepositoryImpl
import com.example.tmdb_api.viewModel.DetailsViewModel
import com.example.tmdb_api.viewModel.SavedViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule= module {
    single {
        RepositoryImpl(
            MovieDatabase(context = androidContext()).getResultDao(),
            MovieDatabase(androidContext()).savedMoviesDao(),
            ApiService()
        ) as Repository
    }

    viewModel { MovieViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
    viewModel { SavedViewModel(get()) }
}