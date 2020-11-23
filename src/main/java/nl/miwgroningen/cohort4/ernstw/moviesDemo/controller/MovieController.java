package nl.miwgroningen.cohort4.ernstw.moviesDemo.controller;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.Director;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.Movie;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.repository.DirectorRepository;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Ernst van der Wal
 * * stuurt de views voor Movie aan
 */

@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorRepository directorRepository;

    @GetMapping({"/", "/movie"})
    protected String showMovie(Model model) {
        model.addAttribute("allMovies", movieRepository.findAll());
        return "movieOverview";
    }

    @GetMapping("/movie/add")
    protected String showMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("allDirectors", directorRepository.findAll());
        return "movieForm";
    }

    @PostMapping("/movie/add")
    protected String saveOrUpdateMovie(@ModelAttribute("movie") Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "movieForm";
        } else {
            movieRepository.save(movie);
            return "redirect:/movie";
        }
    }
}
