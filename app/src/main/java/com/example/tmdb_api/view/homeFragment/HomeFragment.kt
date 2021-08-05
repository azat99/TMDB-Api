package com.example.tmdb_api.view.homeFragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tmdb_api.databinding.FragmentHomeBinding
import com.example.tmdb_api.model.network.InternetCheck
import com.example.tmdb_api.view.BindingFragment
import com.example.tmdb_api.viewModel.MovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val movieViewModel: MovieViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            recyclerView.layoutManager = GridLayoutManager(context,2)
            recyclerView.setHasFixedSize(true)
            InternetCheck{internet ->
                if (!internet){
                    Toast.makeText(context,"Нет подключения к интернету!", Toast.LENGTH_SHORT).show()
                }else{
                    movieViewModel.movieListFromServer()
                }
            }
            movieViewModel.movieListFromDB().observe(viewLifecycleOwner, Observer {
                recyclerView.adapter = MovieAdapter(it)
            })
        }

    }
}