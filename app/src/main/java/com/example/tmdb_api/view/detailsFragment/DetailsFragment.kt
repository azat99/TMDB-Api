package com.example.tmdb_api.view.detailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.tmdb_api.R
import com.example.tmdb_api.databinding.FragmentDetailsBinding
import com.example.tmdb_api.databinding.FragmentHomeBinding
import com.example.tmdb_api.model.entities.SavedMovies
import com.example.tmdb_api.view.BindingFragment
import com.example.tmdb_api.viewModel.DetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : BindingFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val detailsViewModel: DetailsViewModel by viewModel()
    private var position : Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            position = DetailsFragmentArgs.fromBundle(it).moviePosition
        }

        binding.run {
            detailsViewModel.movieListFromDB().observe(viewLifecycleOwner, Observer {

                Glide.with(this@DetailsFragment).load("https://image.tmdb.org/t/p/w500"+it[position].posterPath)
                    .into(ivImage)
                tvTitle.text = it[position].originalTitle
                tvReleaseDate.text = it[position].releaseDate
                tvOverview.text = it[position].overview
                ivSave.setOnClickListener {it2->
                    val save = SavedMovies(
                        posterPath = it[position].posterPath,
                        originalTitle = it[position].originalTitle,
                        releaseDate = it[position].releaseDate,
                        overview = it[position].overview,
                        id = it[position].id
                    )
                    detailsViewModel.saveMovieToDB(save)
                }
            })
        }

    }
}