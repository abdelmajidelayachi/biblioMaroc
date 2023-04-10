package com.elayachiabdelmajid.libMaroc.auth.payload.responses;

import com.elayachiabdelmajid.libMaroc.auth.entities.types.Role;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String phone;

    private Role role;
    private String avatar;
    private String createdAt;
}
