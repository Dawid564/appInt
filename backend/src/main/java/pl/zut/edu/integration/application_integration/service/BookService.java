package pl.zut.edu.integration.application_integration.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import pl.zut.edu.integration.application_integration.dto.BookList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Service
public class BookService {

    private static final String XML_BOOK_PATH = "xml/books.2.xml";

    public void getBooks(){

        try{
            File file = ResourceUtils.getFile("classpath:" + XML_BOOK_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BookList customer = (BookList) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer.getBooks().size());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
