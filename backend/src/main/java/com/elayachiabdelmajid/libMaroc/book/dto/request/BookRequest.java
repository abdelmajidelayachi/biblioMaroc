package com.elayachiabdelmajid.libMaroc.book.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Getter
@Setter
public class BookRequest {

    /*
    exmaple of request book
     {
        "name": "book1",
        "author": "author1",
        "owner": "owner1",
        "price": 10.0,
        "numberOfPages": "100",
        "description": "description1",
        "resume": "resume1",
        "createdAt": "2021-01-01 00:00:00"
    }

     */
    private String name;
    private String author;
    private String owner;
    private Double price;
    private int numberOfPages;
    private String description;

    MultipartFile[] images;
    private String resume;
}
