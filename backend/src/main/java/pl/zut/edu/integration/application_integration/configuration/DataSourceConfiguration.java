package pl.zut.edu.integration.application_integration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import pl.zut.edu.integration.application_integration.dto.BookList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;


@Configuration
public class DataSourceConfiguration {

    private static final String XML_BOOK_PATH = "xml/books.2.xml";

    @Bean
    public BookList getBookManager(){
        BookList bookList = null;
        try {
            File file = ResourceUtils.getFile("classpath:" + XML_BOOK_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            bookList = (BookList) jaxbUnmarshaller.unmarshal(file);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
