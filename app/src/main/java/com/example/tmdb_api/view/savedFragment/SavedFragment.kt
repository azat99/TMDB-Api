package com.example.tmdb_api.view.savedFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tmdb_api.R
import com.example.tmdb_api.databinding.FragmentHomeBinding
import com.example.tmdb_api.databinding.FragmentSavedBinding
import com.example.tmdb_api.model.network.InternetCheck
import com.example.tmdb_api.view.BindingFragment
import com.example.tmdb_api.view.homeFragment.MovieAdapter
import com.example.tmdb_api.viewModel.SavedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SavedFragment : BindingFragment<FragmentSavedBinding>(FragmentSavedBinding::inflate) {

    private val savedViewModel: SavedViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            recyclerView.layoutManager = GridLayoutManager(context,2)
            recyclerView.setHasFixedSize(true)

            savedViewModel.getSavedMovieList().observe(viewLifecycleOwner, Observer {
                recyclerView.adapter = SavedMovieAdapter(it)
            })
        }

    }
}