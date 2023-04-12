package com.elayachiabdelmajid.libMaroc.blog.services;


import com.elayachiabdelmajid.libMaroc.blog.dto.requests.BlogRequest;
import com.elayachiabdelmajid.libMaroc.blog.dto.responses.BlogResponse;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;

public interface BlogService {

    void saveBlog(BlogRequest blogRequest);
    void updateBlog(BlogRequest blogRequest, String slug);
    void deleteBlog(String slug);
    BlogResponse getBlog(String slug);
    PaginationResponse<BlogResponse> getAllBlogs(int page, int size);
}
