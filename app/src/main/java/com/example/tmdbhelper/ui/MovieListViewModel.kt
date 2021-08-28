package com.example.tmdbhelper.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tmdbhelper.data.Movie
import com.example.tmdbhelper.data.MovieListRepository

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: MovieListRepository = MovieListRepository(application)

    val movies: LiveData<List<Movie>> = repo.getMovies()
}