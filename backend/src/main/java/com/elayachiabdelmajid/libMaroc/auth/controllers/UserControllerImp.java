package com.elayachiabdelmajid.libMaroc.auth.controllers;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import com.elayachiabdelmajid.libMaroc.auth.payload.requests.UserRequest;
import com.elayachiabdelmajid.libMaroc.auth.payload.responses.UserResponse;
import com.elayachiabdelmajid.libMaroc.auth.services.UserService;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@RestController
@Slf4j
public class UserControllerImp implements UserController {

    private final UserService userService;

    @GetMapping("{page}/{size}")
    @Override
    public PaginationResponse<UserResponse> getPageUsers(@PathVariable("page") int page, @PathVariable("size") int size) {

        return userService.getAllUsers(page, size);
    }

    @Override
    public void deleteUser(Long idUser) {
        userService.deleteUser(idUser);
    }


}
