package pl.zut.edu.integration.application_integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zut.edu.integration.application_integration.configuration.DataSourceConfiguration;
import pl.zut.edu.integration.application_integration.dto.Book;
import pl.zut.edu.integration.application_integration.dto.BookList;
import pl.zut.edu.integration.application_integration.factories.BookManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private DataSourceConfiguration dataSourceConfiguration;

    private static final String XML_NEW_XML_FILE = "result.xml";

    public BookList getBooks() {
        return dataSourceConfiguration.getBookManager();
    }

    private BookList collectBooksList(Book book) {
        //Book book = new Book("99999", "Java", "java", "123456789", 2000, "java", 123);
        BookManager bookManager = new BookManager(getBooks().getBooks());
        List<Book> listOfBooks = bookManager.searchByTitle("Java");
        listOfBooks.add(book);
        return new BookList(listOfBooks);
    }

    public BookList saveBooks(Book book) {
        BookList bookList = collectBooksList(book);
        return createFileWithBooks(bookList);
    }

    public Book addBookToMemoryStorage(Book book){
        List<Book> allBook = dataSourceConfiguration.getBookManager().getBooks();
        allBook.add(book);
        dataSourceConfiguration.getBookManager().setBooks(allBook);
        return book;
    }

    private BookList createFileWithBooks(BookList bookList) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(bookList, sw);

            FileWriter fileWriter = new FileWriter(XML_NEW_XML_FILE);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf(sw.toString(), 1000);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public List<Book> searchByTitle(String tittle) {
        BookManager bookManager = new BookManager(getBooks().getBooks());
        return bookManager.searchByTitle(tittle);
    }

    public List<Book> searchByAuthor(String author) {
        BookManager bookManager = new BookManager(getBooks().getBooks());
        return bookManager.searchByAuthor(author);
    }

    public Book searchByISBN(String isbn) {
        BookManager bookManager = new BookManager(getBooks().getBooks());
        return bookManager.searchByISBN(isbn);
    }
}
