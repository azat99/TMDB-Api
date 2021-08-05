package com.example.tmdb_api.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdb_api.model.entities.Result
import com.example.tmdb_api.model.entities.SavedMovies
import com.example.tmdb_api.model.entities.ResultDao
import com.example.tmdb_api.model.entities.SavedMoviesDao

@Database(
    entities = [Result::class, SavedMovies::class],
    version = 2
)
abstract class MovieDatabase :RoomDatabase(){

    abstract fun getResultDao(): ResultDao

    abstract fun savedMoviesDao(): SavedMoviesDao

    companion object {

        @Volatile
        private var instance: MovieDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movie_db"
        ).fallbackToDestructiveMigration().build()

    }

}