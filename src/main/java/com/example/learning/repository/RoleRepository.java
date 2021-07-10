package com.example.learning.repository;

import com.example.learning.common.ERole;
import com.example.learning.model.Role;
import com.example.learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(ERole role);
}
