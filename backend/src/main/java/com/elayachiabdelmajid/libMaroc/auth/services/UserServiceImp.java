package com.elayachiabdelmajid.libMaroc.auth.services;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import com.elayachiabdelmajid.libMaroc.auth.payload.requests.UserRequest;
import com.elayachiabdelmajid.libMaroc.auth.payload.responses.UserResponse;
import com.elayachiabdelmajid.libMaroc.auth.repositories.UserPaginationRepository;
import com.elayachiabdelmajid.libMaroc.auth.repositories.UserRepository;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;
import com.elayachiabdelmajid.libMaroc.utils.mapper.EntityDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserPaginationRepository userPaginationRepository;

    public UserServiceImp(UserRepository userRepository, UserPaginationRepository userPaginationRepository) {
        this.userRepository = userRepository;
        this.userPaginationRepository = userPaginationRepository;
    }

    @Override
    public PaginationResponse<UserResponse> getAllUsers(int page, int size) {
        Page<User> users = userPaginationRepository.findAll(PageRequest.of(page, size));
        return EntityDtoMapper.toDtoPageable(users, UserResponse.class);
    }

    @Override
    public UserResponse getUserById(Long idUser) {
        return null;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long idUser) {
        return null;
    }

    @Override
    public void deleteUser(Long idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public User getCurrentUser() {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            String email = userDetails.getUsername();
            return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
