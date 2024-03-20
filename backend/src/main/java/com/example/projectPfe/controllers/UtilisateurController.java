package com.example.projectPfe.controllers;


import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Utilisateur;
import com.example.projectPfe.repositories.UtilisateurRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository userRepository ;

    public UtilisateurController(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/byRole/{role}")
    public List<Utilisateur> getUtilisateursByRole(@PathVariable ERole role) {
        return userRepository.findByRoles(role);
    }


    @GetMapping("/byMat/{mat}")
    public List<Utilisateur> getUtilisateursByRole(@PathVariable String mat) {
        return userRepository.findByMatricule(mat);
    }
}
