package controllers;

import model.Director;
import model.Genre;
import model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    /*@Query("SELECT d FROM Director as d JOIN FETCH d.genreProb as gp")
    List<Director> findAll();
     */

    @Query("SELECT d FROM Director as d JOIN FETCH d.genreProb as gp WHERE gp.genre=:genre")
    List<Director> findAllByGenre(@Param("genre") String genre);

    @Query("SELECT d FROM Director as d JOIN FETCH d.genreProb as gp WHERE gp.genre=:genre")
    List<Director> findAllByGenreOrderByProb(@Param("genre") String genre);


    @Query("SELECT d FROM Director as d JOIN FETCH d.genreProb as ng WHERE ng.genre=:genre")
    List<Director> findAllByGenreOrderByProb(@Param("genre") String genre, Sort sort);

    @Query("SELECT d FROM Director as d JOIN FETCH d.genreProb as ng WHERE ng.genre=:genre")
    List<Director> findAllByGenreOrderByProb(@Param("genre") String genre, Pageable pageable);
    @Query("SELECT d FROM Director as d join d.genreProb as ng")
    Page<Director> findAll(Pageable pageable);

    Director findById(int id);

}
