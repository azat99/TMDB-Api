package com.example.tmdb_api.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.tmdb_api.model.api.ApiService
import com.example.tmdb_api.model.entities.Result
import com.example.tmdb_api.model.entities.ResultDao
import com.example.tmdb_api.model.entities.SavedMovies
import com.example.tmdb_api.model.entities.SavedMoviesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

private const val apiKey = "77d9e37a26d9e044eab84fed8aeb6ebd"
private const val language = "en-US"
private const val page = 1

class RepositoryImpl(
    private val resultDao: ResultDao,
    private val savedMoviesDao: SavedMoviesDao,
    private val apiService: ApiService
) : Repository {


    override suspend fun getMovieListFromServer() {
        try {
            GlobalScope.launch {
                val result = apiService.getMovieList(apiKey, language, page).await()
                resultDao.deleteResult()
                resultDao.insertAllResult(result.results)
            }
        } catch (e: Exception) {
            Log.i("exeption_error", e.printStackTrace().toString())
        }
    }

    override fun getMovieListFromDB(): LiveData<List<Result>> {
        return resultDao.getAllResult()
    }

    override fun saveMovieToDB(likedData: SavedMovies) {
        CoroutineScope(Dispatchers.IO).launch {
            savedMoviesDao.insertLikedData(likedData)
        }
    }

    override fun getSavedMovieFromDB(): LiveData<List<SavedMovies>> {
        return savedMoviesDao.getAllLikedData()
    }
}