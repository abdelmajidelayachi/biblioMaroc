package com.elayachiabdelmajid.libMaroc.book.dto.request;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String name;
    private String author;
    private String owner;
    private Double price;
    private String numberOfPages;
    private String description;
    private String resume;
    private Timestamp createdAt;
}
