package com.elayachiabdelmajid.libMaroc.blog.entity;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Data
@Entity
@Table(name = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "title", nullable = false , unique = true, length = 50)
    private String title;

    @Column(name= "slug", nullable = false , unique = true, length = 50)
    // auto generate slug from title
    private String slug;

    @Column(name= "description", nullable = false , length = 1000)
    private String description;

    private String[] images;

    @Column(name= "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;

    @Column(name= "updated_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private String updatedAt;

    @Column(name= "is_authorised", columnDefinition = "boolean default false")
    private Boolean isAuthorised = false;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name= "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    public void setSlug(String title) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        this.slug = pattern.matcher(title).replaceAll("-").toLowerCase();
    }
}
