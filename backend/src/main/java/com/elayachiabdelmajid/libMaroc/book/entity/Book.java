package com.elayachiabdelmajid.libMaroc.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "books")
@Data
@Builder
@AllArgsConstructor
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String author;

    private String owner;

    private Double price;

    private String numberOfPages;

    private String description;

    private String resume;

    private String[] images;

    @Column(name="create_at", insertable = false, updatable = false)
    private Timestamp createdAt;

}
