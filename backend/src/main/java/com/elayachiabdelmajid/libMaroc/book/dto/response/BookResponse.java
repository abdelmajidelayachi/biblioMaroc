package com.elayachiabdelmajid.libMaroc.book.dto.response;

import com.elayachiabdelmajid.libMaroc.book.entity.Category;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Long id;
    private String name;
    private String author;
    private String owner;
    private Double price;
    private String numberOfPages;
    private String description;
    private Integer discountPercentage;
    private Double quantity;
    private Category category;
    private String resume;
    private String[] images;
    private Boolean is_deleted;
    private String createdAt;
    private String updatedAt;

}
