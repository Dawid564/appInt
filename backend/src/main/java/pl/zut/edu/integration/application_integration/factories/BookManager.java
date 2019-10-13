package pl.zut.edu.integration.application_integration.factories;

import pl.zut.edu.integration.application_integration.dto.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookManager {

    private List<Book> books;

    public BookManager(List<Book> books) {
        this.books = books;
    }

    public List<Book> searchByTitle(String title) {
        return books//
                .stream()//
                .filter(b -> b.getTitle().equalsIgnoreCase(title))//
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return books//
                .stream()//
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))//
                .collect(Collectors.toList());
    }

    public Book searchByISBN(String isbn) {
        return books//
                .stream()//
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))//
                .findFirst()//
                .orElseThrow();
    }
}
