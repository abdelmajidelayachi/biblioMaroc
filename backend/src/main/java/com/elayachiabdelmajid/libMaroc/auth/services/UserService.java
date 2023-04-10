package com.elayachiabdelmajid.libMaroc.auth.services;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import com.elayachiabdelmajid.libMaroc.auth.payload.responses.UserResponse;
import com.elayachiabdelmajid.libMaroc.auth.payload.requests.UserRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;


/**
 * @author Abdelmajid EL AYACHI
 */

public interface UserService {

        PaginationResponse<UserResponse> getAllUsers(int page, int size);

        UserResponse getUserById(Long idUser);

        UserResponse saveUser(UserRequest userRequest);

        UserResponse updateUser(UserRequest userRequest, Long idUser);

        void deleteUser(Long idUser);

        User getCurrentUser();
}
