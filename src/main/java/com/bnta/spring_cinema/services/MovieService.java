package com.bnta.spring_cinema.services;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    private Movie movie;
//    private ArrayList<Movie> movies;

    public MovieService(){
    }
    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public String addMovies(ArrayList<Movie> newMovies){
        String message = "";
        for (Movie newMovie: newMovies) {

            movieRepository.save(newMovie);
//            this.movies.add(movie);
            message += newMovie.getTitle() +" added. ";
        }
        return message;
    }

    public ArrayList<Movie> displayMovies(){
        ArrayList<Movie> movieDisplay = new ArrayList<>();
        for (Movie movie: movieRepository.findAll()) {
            movieDisplay.add(movie);
        }
        return movieDisplay;
    }

//    public Movie updateMovie(Movie movie){
//
//        return movie;
//    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

//    public ArrayList<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(ArrayList<Movie> movies) {
//        this.movies = movies;
//    }
}
