package nl.miwgroningen.cohort4.ernstw.moviesDemo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author Ernst van der Wal
 */
@Entity
public class MovieCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieCopyId;

    private boolean available = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movieId", referencedColumnName = "movieId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Movie movie;


    public Integer getMovieCopyId() {
        return movieCopyId;
    }

    public void setMovieCopyId(Integer movieCopyId) {
        this.movieCopyId = movieCopyId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
