package com.elayachiabdelmajid.libMaroc.blog.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequest {


    private String title;
    private String description;

    private MultipartFile[] images;

}
