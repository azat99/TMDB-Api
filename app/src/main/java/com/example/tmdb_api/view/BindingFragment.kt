package com.example.tmdb_api.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BindingFragment<B : ViewBinding> constructor(
    private val inflate: (inflater: LayoutInflater, container: ViewGroup?, b: Boolean) -> B?
) : Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflate.invoke(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}