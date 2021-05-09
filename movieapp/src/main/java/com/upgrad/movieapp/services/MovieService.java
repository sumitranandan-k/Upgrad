package com.upgrad.movieapp.services;

import com.upgrad.movieapp.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService{

    public Movie acceptMovieDetails(Movie movie);

    public List<Movie> acceptMultiMovieDetails(List<Movie> movie);

    public Movie getMovieDetails(int id);

    public Movie updateMovieDetails(int id, Movie movie);

    public boolean deleteMovie(int id);

    public List<Movie> getAllMovies();

    public Page<Movie> getPagenatedMovieDetails(Pageable pageableRequest);
}
