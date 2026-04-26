package bamfz.service;

import bamfz.dto.book.ResponseBookDto;
import bamfz.model.Book;
import bamfz.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author) {
        this.bookRepository.save(new Book(title, author));

        /* Short for:
        Book to_add = new Book(title, author);
        this.bookRepository.save(to_add);
        */
    }

    private static ResponseBookDto toResponseBookDto(Book book) {
        return new ResponseBookDto(book.getTitle(), book.getAuthor());
    }

    public List<ResponseBookDto> getAllBooks() {
        return this.bookRepository.findAll().stream().map(BookService::toResponseBookDto).toList();
    }
}