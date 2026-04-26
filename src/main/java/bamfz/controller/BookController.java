package bamfz.controller;

import bamfz.dto.book.RequestBookDto;
import bamfz.dto.book.ResponseBookDto;
import bamfz.model.Book;
import bamfz.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public void addBookRoute(RequestBookDto requestDto) {
        this.bookService.addBook(requestDto.title(), requestDto.author());
    }

    @GetMapping("/get-all")
    public List<ResponseBookDto> getAllBooksRoute() {
        return this.bookService.getAllBooks();
    }
}
