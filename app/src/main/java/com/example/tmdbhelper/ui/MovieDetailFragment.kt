package com.example.tmdbhelper.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbhelper.data.Movie
import com.example.tmdbhelper.databinding.FragmentMovieDetailBinding
import com.example.tmdbhelper.readableFormat

class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = MovieDetailFragmentArgs.fromBundle(requireArguments()).id

        val viewModelFactory = MovieDetailViewModelFactory(id, requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movie.observe(viewLifecycleOwner, {
            setData(it)
        })
    }

    private fun setData(movie: Movie) {
        TODO("Not yet implemented")
        binding.movieTitle.text = movie.title
        binding.movieOverview.text = movie.overview
        binding.movieReleaseDate.text = movie.releaseDate.readableFormat()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}