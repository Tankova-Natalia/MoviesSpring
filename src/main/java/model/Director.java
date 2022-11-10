package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @ElementCollection
    @CollectionTable(name = "directors_genres", joinColumns = {@JoinColumn(name = "director_id")}, foreignKey = @ForeignKey(name = "idx_director_id"))
    private Set<GenreProb> genreProb;
    @ManyToMany(mappedBy = "directors")
    private Set<Movie> movies = new HashSet<>();

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Director() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<GenreProb> getGenreProb() {
        return genreProb;
    }

    public void setGenreProb(Set<GenreProb> genreProb) {
        this.genreProb = genreProb;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", genreProbSize=" + genreProb.size() +
                ", genreProb=" + genreProb +
                '}';
    }

}