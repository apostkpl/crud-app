package com.crudbasics.crudapp.controller;

import com.crudbasics.crudapp.entity.Movie;
import com.crudbasics.crudapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    // For the Home Page
    @GetMapping("/")
    public String viewHomePage(Model model) {
        Iterable<Movie> listMovies = movieRepository.findAll();
        model.addAttribute("listMovies", listMovies); // (Attribute name, Actual Object)
        return "index"; // This is an HTML file for Thymeleaf
    }

    // Returns the form to add a new movie
    @GetMapping("/showNewMovieForm")
    public String showNewMovieForm(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "new_movie"; //This is an HTML file for Thymeleaf
    }

    // Adds movie to the database and redirects back to root
    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieRepository.save(movie);
        return "redirect:/";
    }
}