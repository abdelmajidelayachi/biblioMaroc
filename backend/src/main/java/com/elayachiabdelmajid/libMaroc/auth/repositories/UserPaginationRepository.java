package com.elayachiabdelmajid.libMaroc.auth.repositories;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPaginationRepository extends PagingAndSortingRepository<User, Long> {
    //
}
