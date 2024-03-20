package com.example.projectPfe.repositories;

import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Integer> {
    @Query("SELECT r FROM Role r WHERE r.name = :roleName")
    Role findByName(@Param("roleName") ERole roleName);


}
