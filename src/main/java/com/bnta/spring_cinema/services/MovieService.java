package com.bnta.spring_cinema.services;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    private Movie movie;

    public MovieService(){
    }
    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public String addMovies(ArrayList<Movie> newMovies){
        String message = "";
        for (Movie newMovie: newMovies) {

            movieRepository.save(newMovie);
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

    public Movie updateMovie(long id, Movie updateMovie){
        Movie movie = movieRepository.getReferenceById(id);
        movie.setTitle(updateMovie.getTitle());
        movie.setRating(updateMovie.getRating());
        movie.setDuration(updateMovie.getDuration());
        movieRepository.save(movie);
        return movie;
    }

    public String deleteMovie(long id){
        Movie movie = movieRepository.getReferenceById(id);
        movieRepository.delete(movie);
        return String.format("%s deleted", movie.getTitle());
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
