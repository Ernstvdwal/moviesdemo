package nl.miwgroningen.cohort4.ernstw.moviesDemo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ernst van der Wal
 */

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer directorId;

    private String directorName;

    @OneToMany(mappedBy = "director")
    private List<Movie> myMovies;


    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    //@TODO fixen
    public int getNumberOfMovies() {return myMovies.size();}
}
