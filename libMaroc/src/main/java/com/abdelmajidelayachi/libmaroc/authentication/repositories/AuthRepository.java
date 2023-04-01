package com.abdelmajidelayachi.libmaroc.authentication.repositories;

import com.abdelmajidelayachi.libmaroc.authentication.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity,Long> {
}
