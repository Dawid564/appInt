package pl.zut.edu.integration.application_integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zut.edu.integration.application_integration.dto.Book;
import pl.zut.edu.integration.application_integration.service.BookService;

import java.util.List;

@RequestMapping("/api/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
        return bookService.getBooks().getBooks();
    }

    @GetMapping("/oneBook")
    public Book getOneBooks(){
        return bookService.getBooks().getBooks().get(0);
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book){
        return bookService.addBookToMemoryStorage(book);
    }

    @GetMapping("/searchByTitle/{tittle}")
    public List<Book> searchByTitle(@PathVariable String tittle){
        return bookService.searchByTitle(tittle);
    }

    @GetMapping("/searchByAuthor/{author}")
    public List<Book> searchByAuthor(@PathVariable String author){
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/searchByISBN/{isbn}")
    public Book searchByISBN(@PathVariable String isbn){
        return bookService.searchByISBN(isbn);
    }
}
