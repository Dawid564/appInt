package pl.zut.edu.integration.application_integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.zut.edu.integration.application_integration.dto.Book;
import pl.zut.edu.integration.application_integration.factories.BookManager;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApplicationIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationIntegrationApplication.class, args);

        List<Book> books = new ArrayList<>();
        books.add(new Book("b1", "Koparka dla opornych", "Zdzisław Maliniak", "123456789", 2000, "Dawid", 123));
        books.add(new Book("b2", "Java rulez", "James Gosling", "2244668800", 1998, "Dawid", 234));
        books.add(new Book("b3", "Sadownictwo dla początkujących", "Steve Jobs", "13579135", 1990, "Dawid", 345));
        BookManager bookManager = new BookManager(books);

        List<Book> booksByTitle = bookManager.searchByTitle("Java rulez");
        System.out.println(booksByTitle.get(0).getAuthor());

        List<Book> booksByAuthor = bookManager.searchByAuthor("James Gosling");
        System.out.println(booksByAuthor.get(0).getAuthor());

        Book bookBiIsbn = bookManager.searchByISBN("2244668800");
        System.out.println(bookBiIsbn.getAuthor());
    }

}
