package pl.zut.edu.integration.application_integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zut.edu.integration.application_integration.service.BookService;

@RequestMapping("/api/book")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/test")
    public String test(){
        bookService.getBooks();
        return "test";
    }
}
