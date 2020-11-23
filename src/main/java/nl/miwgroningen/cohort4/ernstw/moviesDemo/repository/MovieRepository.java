package nl.miwgroningen.cohort4.ernstw.moviesDemo.repository;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Ernst van der Wal
 * stuurt de views voor Movie aan
 */

public interface MovieRepository extends JpaRepository <Movie, Integer> {

    Optional<Movie> findByTitle(String title);
}
