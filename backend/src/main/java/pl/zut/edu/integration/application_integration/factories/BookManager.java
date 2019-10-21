package pl.zut.edu.integration.application_integration.factories;

import pl.zut.edu.integration.application_integration.dto.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookManager {

    private List<Book> books;

    public BookManager(List<Book> books) {
        this.books = books;
    }

    public List<Book> searchByTitle(String title) {
        return books//
                .stream()//
                .filter(b -> b.getTitle().contains(title))//
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        Map<String, List<String>> isbnAndAuthorList = books.stream().filter( b -> b.getAuthors() != null).collect( Collectors.toMap(Book::getIsbn, b -> b.getAuthors().getAuthor()));
        List<String> isbnResultByAuthor = new ArrayList<>();
        isbnAndAuthorList.forEach( (isbnKey, authorsList) -> {
            for(String authors : authorsList){
                if(authors.contains(author)){
                    isbnResultByAuthor.add(isbnKey);
                }
            }
        });

        return books//
                .stream()
                .filter( a -> isbnResultByAuthor.contains(a.getIsbn()))
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
