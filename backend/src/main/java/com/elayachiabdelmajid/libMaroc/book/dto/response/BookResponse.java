package com.elayachiabdelmajid.libMaroc.book.dto.response;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String name;
    private String author;
    private String owner;
    private Double price;
    private String numberOfPages;
    private String description;
    private String resume;
    private Boolean is_deleted;
    private Timestamp createdAt;

}
