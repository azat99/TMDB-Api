package com.example.tmdb_api.view.savedFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_api.R
import com.example.tmdb_api.model.entities.Result
import com.example.tmdb_api.model.entities.SavedMovies
import com.squareup.picasso.Picasso

class SavedMovieAdapter(private val list: List<SavedMovies>) :
    RecyclerView.Adapter<SavedMovieAdapter.NewsViewHolder>() {
    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val iv = holder.itemView.findViewById<ImageView>(R.id.iv_image)
        Glide.with(holder.itemView.context).load("https://image.tmdb.org/t/p/w500"+list[position].posterPath)
            .into(iv)
        holder.itemView.setOnClickListener {
            val action = SavedFragmentDirections.actionNavigationSavedToDetailsFragment()
            action.moviePosition = position
            Navigation.findNavController(it).navigate(action)
        }
    }

}