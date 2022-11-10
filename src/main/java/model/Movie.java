package model;


import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "movies")
public class Movie {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column
    private String name;
    //@Column
    private Integer year;
    //@Column
    private Float rank;
    //@ElementCollection
    //@CollectionTable(name = "movies_directors", joinColumns = @JoinColumn(name = "movie_id"), foreignKey = @ForeignKey(name = "idx_movie_id"))
    //@ManyToMany
    //@JoinColumn(name = "movie_id")
    private Set<Director> directors = new HashSet<Director>();

    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getRank() {
        return rank;
    }

    public void setRank(Float rank) {
        this.rank = rank;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public void addDirector(Director director){
        directors.add(director);
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", rank=" + rank +
                //", directors=" + directors +
                '}';
    }
}
