package nl.miwgroningen.cohort4.ernstw.moviesDemo.repository;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.MovieCopy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Ernst van der Wal
 */
public interface MovieCopyRepository extends JpaRepository<MovieCopy, Integer> {
}
