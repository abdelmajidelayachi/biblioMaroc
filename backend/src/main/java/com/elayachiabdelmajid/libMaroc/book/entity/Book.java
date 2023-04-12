package com.elayachiabdelmajid.libMaroc.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "books")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String author;

    private String owner;

    private Double price;

    private Double quantity;

    private Integer discountPercentage;

    private Category category;

    private Integer numberOfPages;

    private String description;

    private String resume;

    private String[] images;

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;

    @Column(name = "updated_at", updatable = false , insertable = false ,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private String updated_at;

}
