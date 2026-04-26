package bamfz.controller;

import bamfz.dto.film.RequestFilmDto;
import bamfz.dto.film.ResponseFilmDto;
import bamfz.model.Film;
import bamfz.service.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("films")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }
    @PostMapping
    public void addFilm(RequestFilmDto requestFilmDto){
        this.filmService.addFilm(requestFilmDto);
    }
    @GetMapping
    public List<ResponseFilmDto> getFilms(){
        return this.filmService.getFilms();
    }
}
