package nl.miwgroningen.cohort4.ernstw.moviesDemo.service;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.repository.MovieUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Ernst van der Wal
 */
@Service
public class MovieUserDetailsService implements UserDetailsService {

    @Autowired
    MovieUserRepository movieUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return movieUserRepository.findByUsername(s).orElseThrow(
                () -> new UsernameNotFoundException("User " + s + "was not found.")
        );

    }
}
