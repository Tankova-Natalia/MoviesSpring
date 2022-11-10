package controllers;

import model.Direction;
import model.Director;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository repository;

    public List<Director> findAll() {
        return repository.findAll();
    }
    public List<Director> findAllByGenre(String genre) {
        return repository.findAllByGenre(genre);
    }
    public List<Director> findAllByGenreOrderByProb(String genre) {
        return repository.findAllByGenreOrderByProb(genre);
    }
    public List<Director> findAllByGenreOrderByProb(String genre, Sort sort) {
        return repository.findAllByGenreOrderByProb(genre, sort);
    }
public List<Director> findAllByGenreOrderByProb(String genre, Pageable pageable) {
        return repository.findAllByGenreOrderByProb(genre, pageable);
    }
public List<Director> findAllByGenreOrderByProb(String genre, Pageable pageable, Integer n) {
        return repository.findAllByGenreOrderByProb(genre, pageable);
    }


    public Director findById(int id){
        return repository.findById(id);
    }


}
