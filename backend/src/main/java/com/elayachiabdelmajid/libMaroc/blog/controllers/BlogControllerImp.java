package com.elayachiabdelmajid.libMaroc.blog.controllers;

import com.elayachiabdelmajid.libMaroc.blog.dto.requests.BlogRequest;
import com.elayachiabdelmajid.libMaroc.blog.dto.responses.BlogResponse;
import com.elayachiabdelmajid.libMaroc.blog.services.BlogService;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blogs")
public class BlogControllerImp implements BlogController{

        private final BlogService blogService;
        @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
        @Override
        public void saveBlog(@ModelAttribute BlogRequest blogRequest) {
            blogService.saveBlog(blogRequest);
        }

        @PutMapping(value = "{slug}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
        @Override
        public void updateBlog(@ModelAttribute BlogRequest blogRequest, @PathVariable("slug") String slug) {
            blogService.updateBlog(blogRequest, slug);
        }

        @DeleteMapping("{slug}")
        @Override
        public void deleteBlog(@PathVariable("slug") String slug) {
            blogService.deleteBlog(slug);
            //
        }

        @GetMapping("{slug}")
        @Override
        public BlogResponse getBlog(@PathVariable("slug") String slug) {
            return blogService.getBlog(slug);
        }

        @GetMapping("{page}/{size}")
        @Override
        public PaginationResponse<BlogResponse> getAllBlogs(@PathVariable("page") int page,@PathVariable("size") int size) {
            return blogService.getAllBlogs(page, size);
        }
}
