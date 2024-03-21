package com.example.projectPfe.repository;

import com.example.projectPfe.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByEmail(String email);

    Boolean existsByEmail(String email);

}
