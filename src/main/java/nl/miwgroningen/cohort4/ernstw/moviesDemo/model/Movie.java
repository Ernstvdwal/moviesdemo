package nl.miwgroningen.cohort4.ernstw.moviesDemo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ernst van der Wal
 * inhoud v/d movie
 */

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "directorId", referencedColumnName = "directorId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Director director;

    @OneToMany(mappedBy = "movie")
    private List<MovieCopy> movieCopies;

    public int getNumberMovieCopies() {
        return movieCopies.size();
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    //TODO fixen
    public void setDirector(Director director) {
        this.director = director;
    }
}
