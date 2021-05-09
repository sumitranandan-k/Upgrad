package com.upgrad.movieapp.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "movie_new")
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int movieId;

  @Column(length = 50, nullable = false, unique = true)
  private String movieName;

  @Column(name = "movie_desc", length = 500, nullable = true)
  private String movieDescription;

  @Column(nullable = true)
  private LocalDateTime releaseDate;

  @Column(nullable = true)
  private int duration;

  @Column(length = 500, nullable = true)
  private String coverPhotoUrl;

  @Column(length = 500, nullable = true)
  private String trailerUrl;

  public Movie() {

  }

  @Override
  public String toString() {
    return "Movie{" + "movieId=" + movieId + ", movieName='" + movieName + '\'' + ", movieDescription='"
        + movieDescription + '\'' + ", releaseDate=" + releaseDate + ", duration=" + duration + ", coverPhotoUrl='"
        + coverPhotoUrl + '\'' + ", trailerUrl='" + trailerUrl + '\'' + '}';
  }
}