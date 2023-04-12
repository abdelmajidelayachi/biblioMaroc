package com.elayachiabdelmajid.libMaroc.blog.controllers;

import com.elayachiabdelmajid.libMaroc.blog.dto.requests.BlogRequest;
import com.elayachiabdelmajid.libMaroc.blog.dto.responses.BlogResponse;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;

public interface BlogController {

    void saveBlog(BlogRequest blogRequest);
    void updateBlog(BlogRequest blogRequest, String slug);
    void deleteBlog(String slug);
    BlogResponse getBlog(String slug);
    PaginationResponse<BlogResponse> getAllBlogs(int page, int size);
}
