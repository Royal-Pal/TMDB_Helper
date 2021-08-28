package com.example.tmdbhelper.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tmdbhelper.data.Movie
import com.example.tmdbhelper.data.MovieDetailRepository

class MovieDetailViewModel(id: Long, application: Application) : AndroidViewModel(application) {

    private val repo: MovieDetailRepository = MovieDetailRepository(application)

    val movie: LiveData<Movie> = repo.getMovie(id)
}