package com.elayachiabdelmajid.libMaroc.auth.controllers;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import com.elayachiabdelmajid.libMaroc.auth.payload.responses.UserResponse;
import com.elayachiabdelmajid.libMaroc.auth.payload.requests.UserRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;

import java.util.Map;


public interface UserController {

    PaginationResponse<UserResponse> getPageUsers(int page, int size);

    void deleteUser(Long idUser);


}
