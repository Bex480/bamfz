package bamfz.service;

import bamfz.dto.film.RequestFilmDto;
import bamfz.dto.film.ResponseFilmDto;
import bamfz.model.Film;
import bamfz.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }
    public void addFilm(RequestFilmDto requestFilmDto){
        this.filmRepository.save(new Film(requestFilmDto.title(),requestFilmDto.genre()));
    }
    public List<ResponseFilmDto> getFilms(){
        return this.filmRepository.findAll().stream().map(FilmService::toDto).toList();
    }
    private static ResponseFilmDto toDto(Film film){
        return new ResponseFilmDto(film.getTitle(), film.getGenre());
    }
}
