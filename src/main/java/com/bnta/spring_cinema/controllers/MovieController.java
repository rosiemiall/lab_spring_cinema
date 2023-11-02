package com.bnta.spring_cinema.controllers;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<ArrayList<Movie>> viewMovies(){
        ArrayList<Movie> movies = movieService.displayMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional> getMovieId(@PathVariable long id){
        Optional movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody ArrayList<Movie> movies){

        String message = movieService.addMovies(movies);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id,@RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id){
        String message = movieService.deleteMovie(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
