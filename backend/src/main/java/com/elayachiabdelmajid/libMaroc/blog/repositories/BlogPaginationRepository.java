package com.elayachiabdelmajid.libMaroc.blog.repositories;

import com.elayachiabdelmajid.libMaroc.blog.entity.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPaginationRepository extends PagingAndSortingRepository<Blog, Long> {
    //
}
