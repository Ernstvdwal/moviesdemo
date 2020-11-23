package nl.miwgroningen.cohort4.ernstw.moviesDemo.controller;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.Movie;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.MovieCopy;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.repository.MovieCopyRepository;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Ernst van der Wal
 */

@Controller
public class MovieCopyController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCopyRepository movieCopyRepository;

    @GetMapping("/movieCopy/add/{movieId}")
    protected String addMovieCopy(@PathVariable("movieId")Integer movieId) {
        Optional<Movie> movieBox = movieRepository.findById(movieId);
        if (movieBox.isPresent()) {
            MovieCopy movieCopy = new MovieCopy();
            movieCopy.setMovie(movieBox.get());
            movieCopyRepository.save(movieCopy);
        }
        return "redirect:/movie";
    }

    @GetMapping ("/movieCopy/add/t/{movieTitle}")
    protected String addMovieCopyByTitle(@PathVariable("movieTitle") String movieTitle) {
        Optional<Movie> movieBox = movieRepository.findByTitle(movieTitle);
        if (movieBox.isPresent()) {
            MovieCopy movieCopy = new MovieCopy();
            movieCopy.setMovie(movieBox.get());
            movieCopyRepository.save(movieCopy);
        }
        return "redirect:/movie";
    }


}
