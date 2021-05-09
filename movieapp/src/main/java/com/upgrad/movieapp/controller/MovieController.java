package com.upgrad.movieapp.controller;

import com.upgrad.movieapp.dto.MovieDTO;
import com.upgrad.movieapp.entities.Movie;
import com.upgrad.movieapp.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/movie_app/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(MovieDTO movieDTO){
        Movie newMovie = modelMapper.map(movieDTO, Movie.class);

        Movie saveMovie = movieService.acceptMovieDetails(newMovie);

        MovieDTO savedMovieDto = modelMapper.map(saveMovie, MovieDTO.class);

        return  new ResponseEntity(savedMovieDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMovies(){

        List<Movie> movieList = movieService.getAllMovies();
        List<MovieDTO> movieDTOList = new ArrayList<>();

        for (Movie movie : movieList){
            movieDTOList.add(modelMapper.map(movie, MovieDTO.class));
        }
        return new ResponseEntity(movieDTOList, HttpStatus.OK);
    }

    @GetMapping(" /movies/{id} " )
    public ResponseEntity getMovieBasedOnId(@PathVariable(name = "id") int id) {
        Movie responseMovie = movieService.getMovieDetails(id);
        MovieDTO responseMovieDTO = modelMapper.map(responseMovie, MovieDTO.class);
        return new ResponseEntity(responseMovieDTO, HttpStatus.OK);
    }

    @PutMapping (value = " /movies/{id} ", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovie(@PathVariable(name = "id") int id,
                                      @RequestBody MovieDTO movieDTO) {
        Movie newMovie = modelMapper.map(movieDTO, Movie.class);
        Movie updatedMovie = movieService.updateMovieDetails(id, newMovie);

        MovieDTO updatedMovieDTO = modelMapper.map(updatedMovie,MovieDTO.class);

        return new ResponseEntity(updatedMovieDTO, HttpStatus.ACCEPTED);
    }
}
