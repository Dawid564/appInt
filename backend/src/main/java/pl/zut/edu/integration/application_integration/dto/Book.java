package pl.zut.edu.integration.application_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="Book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlAttribute
    private String id;

    @XmlElement
    private String title;

    @XmlElement(name="authors")
    private Author authors;

    @XmlElement
    private String isbn;

    @XmlElement
    private Integer year;

    @XmlElement
    private String publisher;

    @XmlElement
    private Integer pages;
}
