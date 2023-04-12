package com.elayachiabdelmajid.libMaroc.blog.repositories;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import com.elayachiabdelmajid.libMaroc.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    // delete by slug
    void deleteBySlug(String slug);

    Optional<Blog> findBySlug(String slug);
}
