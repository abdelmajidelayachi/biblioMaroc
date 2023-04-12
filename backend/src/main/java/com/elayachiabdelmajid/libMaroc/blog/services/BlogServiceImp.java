package com.elayachiabdelmajid.libMaroc.blog.services;

import com.elayachiabdelmajid.libMaroc.auth.services.UserService;
import com.elayachiabdelmajid.libMaroc.blog.dto.requests.BlogRequest;
import com.elayachiabdelmajid.libMaroc.blog.dto.responses.BlogResponse;
import com.elayachiabdelmajid.libMaroc.blog.entity.Blog;
import com.elayachiabdelmajid.libMaroc.blog.repositories.BlogPaginationRepository;
import com.elayachiabdelmajid.libMaroc.blog.repositories.BlogRepository;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;
import com.elayachiabdelmajid.libMaroc.globals.services.ImageUploadService;
import com.elayachiabdelmajid.libMaroc.utils.mapper.EntityDtoMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BlogServiceImp implements BlogService{

    private final ImageUploadService imageUploadService;
    private final BlogRepository blogRepository;
    private final UserService userService;
    private final BlogPaginationRepository blogPaginationRepository;

    public BlogServiceImp(ImageUploadService imageUploadService, BlogRepository blogRepository, UserService userService, BlogPaginationRepository blogPaginationRepository) {
        this.imageUploadService = imageUploadService;
        this.blogRepository = blogRepository;
        this.userService = userService;
        this.blogPaginationRepository = blogPaginationRepository;
    }
    @Override
    public void saveBlog(BlogRequest blogRequest) {
        MultipartFile[] images = blogRequest.getImages();
        String[] urls =  imageUploadService.storeImageInCloud(images);
        Blog blog = EntityDtoMapper.toEntity(blogRequest, Blog.class);
        blog.setImages(urls);
        blog.setSlug(blogRequest.getTitle());
        blog.setUser(userService.getCurrentUser());
        blogRepository.save(blog);
    }



    @Transactional
    @Override
    public void updateBlog(BlogRequest blogRequest, String slug) {
        MultipartFile[] images = blogRequest.getImages();
        String[] urls =  imageUploadService.storeImageInCloud(images);
        Blog blog = EntityDtoMapper.toEntity(blogRequest, Blog.class);
        blog.setImages(urls);
    }

    @Override
    public void deleteBlog(String slug) {
        Blog blog = blogRepository.findBySlug(slug).orElseThrow(() -> new RuntimeException("Blog not found"));
        blogRepository.delete(blog);
    }

    @Override
    public BlogResponse getBlog(String slug) {
        Blog blog = blogRepository.findBySlug(slug).orElseThrow(() -> new RuntimeException("Blog not found"));
        return EntityDtoMapper.toDto(blog, BlogResponse.class);

    }

    @Override
    public PaginationResponse<BlogResponse> getAllBlogs(int page, int size) {
        Page<Blog> blogs = blogPaginationRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size));
        return EntityDtoMapper.toDtoPageable(blogs, BlogResponse.class);
    }
}
