package com.upgrad.movieapp.services;

import com.upgrad.movieapp.dao.MovieDAO;
import com.upgrad.movieapp.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    public MovieDAO movieDAO;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDAO.save(movie);
    }

    @Override
    public List<Movie> acceptMultiMovieDetails(List<Movie> movies) {
        List<Movie> savedMovies = new ArrayList<>();

        for (Movie movie : movies){
            savedMovies.add(acceptMovieDetails(movie));
        }
        return savedMovies;
    }

    @Override
    public Movie getMovieDetails(int id) {
        return movieDAO.findById(id).get();
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) {
        Movie savedMovie = getMovieDetails(id);

        if(!savedMovie.equals(null)){
            savedMovie.setMovieName(movie.getMovieName());
            savedMovie.setDuration(movie.getDuration());
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
            savedMovie.setReleaseDate(movie.getReleaseDate());
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }
        return movieDAO.save(savedMovie) ;
    }

    @Override
    public boolean deleteMovie(int id) {
        Movie savedMovie = getMovieDetails(id);

        if(savedMovie.equals(null)) {
            return false;
        }

        movieDAO.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.findAll();
    }

    @Override
    public Page<Movie> getPagenatedMovieDetails(Pageable pageableRequest) {
        return movieDAO.findAll(pageableRequest);
    }
}
