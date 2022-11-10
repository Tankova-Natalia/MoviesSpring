package model;

import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;

public class NumberGenre {
    @Min(value = 1, message = "Number should be greater then 0")
    private Integer number;
    private Genre genre;
    //private Direction direction;
    private Sort.Direction direction;

    public NumberGenre() {
    }

    public NumberGenre(Integer number, Genre genre, Sort.Direction direction) {
        this.number = number;
        this.genre = genre;
        this.direction = direction;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
