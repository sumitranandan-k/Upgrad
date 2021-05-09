package com.upgrad.movieapp;

import com.upgrad.movieapp.entities.Movie;
import com.upgrad.movieapp.services.MovieService;
import com.upgrad.movieapp.services.MovieServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MovieappApplication.class, args);
		/*
		MovieService movieService = applicationContext.getBean(MovieService.class);
		for(int i = 1; i<=100;i++){
			Movie movie = new Movie();

			movie.setMovieName("Movie name"+String.valueOf(i));
			movie.setMovieDescription("Movie descrption"+String.valueOf(i));
			movie.setDuration(120 + i%20);
			movie.setReleaseDate(LocalDateTime.of(2013,(i%12)+1,(i%27)+1,(i%23)+1,(i%59)+1));
			movie.setCoverPhotoUrl("https://movieImage.com/"+String.valueOf(i));
			movie.setTrailerUrl("https://www.youtube.com/watch?v="+String.valueOf(i));

			movieService.acceptMovieDetails(movie).getMovieId();
		}*/
	}

	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}

}
