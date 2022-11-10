package model;

import javax.persistence.Embeddable;

@Embeddable
public class GenreProb {
    String genre;
    Float prob;

    public GenreProb() {
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Float getProb() {
        return prob;
    }

    public void setProb(Float prob) {
        this.prob = prob;
    }


    @Override
    public String toString() {
        return "GenreProb{" +
                "genre='" + genre + '\'' +
                ", prob=" + prob +
                '}';
    }
}
