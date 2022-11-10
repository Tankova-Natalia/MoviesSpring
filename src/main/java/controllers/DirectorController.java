package controllers;


import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    DirectorService directorService;
    final int N = 5;
    int number;
    int total;
    String genre;
    Sort sort;

    @GetMapping("/selectGenre")
    public String selectGenre(Model model){
        NumberGenre ng = new NumberGenre();
        model.addAttribute("ng", ng);
        return "select_genre";
    }

    @PostMapping
    public String showDirectors(@Valid @ModelAttribute("ng") NumberGenre ng, BindingResult result, Model model){
        if(result.hasErrors())
            return "select_genre";
        genre = ng.getGenre().name();
        if (genre.equals("Sci_Fi"))
            genre = "Sci-Fi";
        number = ng.getNumber();
        sort = new Sort(new Sort.Order(ng.getDirection(), "ng.prob"));
        Pageable pageNew = new PageRequest(0,number < N ? number : N, sort);
        List<Director> directors = directorService.findAllByGenreOrderByProb(genre, pageNew);
        List<Director> allDirectors = (directorService.findAllByGenreOrderByProb(genre, sort));
        if (number > allDirectors.size())
            number = allDirectors.size();
        total =(int) Math.ceil(number * 1. / 5);
        model.addAttribute("total", total);
        model.addAttribute("page", pageNew.getPageNumber());
        model.addAttribute("directors", directors);
        return "directors";
    }

    @GetMapping(value="/findpage")
    public String showPageTable(@RequestParam("page") Integer page, Model model) {
        Pageable pageNew = new PageRequest(page, N, sort);
        List<Director> directors = directorRepository.findAllByGenreOrderByProb(genre,pageNew);
        if (number<N*(page+1))
            directors = directors.subList(0,number-N*page);
        model.addAttribute("total", total);
        model.addAttribute("page", pageNew.getPageNumber());
        model.addAttribute("directors", directors);
        return "directors";
    }

    @GetMapping("/{id}")
    public String getDirector(@PathVariable("id") Integer id, Model model){
        Director director = directorService.findById(id);
        List<Movie> movies = movieRepository.findALLByDirectorsContains(director);
        model.addAttribute("director", director);
        model.addAttribute("movies", movies);
        return "director";
    }
}
