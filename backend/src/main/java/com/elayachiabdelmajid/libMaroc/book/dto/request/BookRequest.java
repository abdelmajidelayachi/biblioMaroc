package com.elayachiabdelmajid.libMaroc.book.dto.request;

import com.elayachiabdelmajid.libMaroc.book.entity.Category;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class BookRequest  {


    private String name;
    private String author;
    private String owner;
    private Double price;
    private int numberOfPages;
    private String description;
    private int discountPercentage;

    private Double quantity;
    private String category;

    MultipartFile[] images;
    private String resume;
}
