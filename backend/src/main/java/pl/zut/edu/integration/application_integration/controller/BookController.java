package pl.zut.edu.integration.application_integration.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;
import pl.zut.edu.integration.application_integration.dto.Book;
import pl.zut.edu.integration.application_integration.service.BookService;

import java.util.List;

@RequestMapping("/api/book")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
        return bookService.getBooks().getBooks();
    }

    @GetMapping("/oneBook")
    public Book getOneBooks(){
        return bookService.getBooks().getBooks().get(0);
    }

    @GetMapping("/test")
    public String takeTest(){
        return "test";
    }

    @GetMapping("/saveBook")
    public void saveBook(Book book){
        bookService.saveBooks(book);
    }

    @GetMapping("/searchByTitle")
    public List<Book> searchByTitle(@PathVariable String tittle){
        return bookService.searchByTitle(tittle);
    }

    @GetMapping("/searchByAuthor")
    public List<Book> searchByAuthor(@PathVariable String author){
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/searchByISBN")
    public Book searchByISBN(@PathVariable String isbn){
        return bookService.searchByISBN(isbn);
    }
}
