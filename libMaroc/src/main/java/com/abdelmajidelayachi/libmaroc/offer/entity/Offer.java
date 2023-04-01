package com.abdelmajidelayachi.libmaroc.offer.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "offers")
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_generator")
    @SequenceGenerator(name = "offer_generator", sequenceName = "offer_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String type;
    private SlugBooks slugs;

    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;

    @Column(name = "updated_at", updatable = false , insertable = false ,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private String updatedAt;

}
