package com.abdelmajidelayachi.libmaroc.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
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

    @Column(name="create_at", insertable = false, updatable = false)
    private Timestamp createdAt;

}
