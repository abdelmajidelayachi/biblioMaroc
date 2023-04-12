package com.elayachiabdelmajid.libMaroc.blog.dto.responses;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponse {

        private Long id;
        private String title;
        private String description;
        private String[] images;
        private Boolean is_deleted;
        private User user;
        private String createdAt;
        private String updatedAt;
}
