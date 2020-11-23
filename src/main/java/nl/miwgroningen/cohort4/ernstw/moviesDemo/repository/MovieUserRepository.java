package nl.miwgroningen.cohort4.ernstw.moviesDemo.repository;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.MovieUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Ernst van der Wal
 */
public interface MovieUserRepository extends JpaRepository<MovieUser, Integer> {
        Optional<MovieUser> findByUsername(String username);
}
