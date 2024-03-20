package com.example.projectPfe.services;

import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Utilisateur;
import com.example.projectPfe.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository ;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findByRole(ERole role)
    {
        return utilisateurRepository.findByRoles(role);
    }

    public  List<Utilisateur> findbyMat(String mat)
    {
        return utilisateurRepository.findByMatricule(mat);
    }
}
