package com.example.projectPfe.repositories;

import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Integer> {
    Optional<Role> findByName(ERole roleAdmin);
}
