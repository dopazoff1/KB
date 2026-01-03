package com.crdpls.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crdpls.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}