package com.elayachiabdelmajid.libMaroc.book.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Getter
@Setter
public class BookRequest  {


    private String name;
    private String author;
    private String owner;
    private Double price;
    private int numberOfPages;
    private String description;

    MultipartFile[] images;
    private String resume;
}
