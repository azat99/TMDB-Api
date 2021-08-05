package com.example.tmdb_api.model.entities

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SavedMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLikedData(likedData: SavedMovies)

    @Query("select * from savedmovies")
    fun getAllLikedData(): LiveData<List<SavedMovies>>

}