package com.example.projectPfe.services;

import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Role;
import com.example.projectPfe.models.Utilisateur;
import com.example.projectPfe.repositories.RoleRepository;
import com.example.projectPfe.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository ;

    private final RoleRepository roleRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }

    public List<Utilisateur> findByRole(ERole role)
    {
        return utilisateurRepository.findByRoles(role);
    }

    public  List<Utilisateur> findbyMat(String mat)
    {
        return utilisateurRepository.findByMatricule(mat);
    }

    public void affecterRole(Utilisateur utilisateur, ERole role) {
        Role roleEntity = roleRepository.findByName(role);
        if (roleEntity != null) {
            utilisateur.getRoles().add(roleEntity);
            utilisateurRepository.save(utilisateur);
        } else {
            throw new IllegalArgumentException("Le rôle spécifié n'existe pas.");
        }
    }

    public void limiterRole(Utilisateur utilisateur, ERole role) {
        Role roleEntity = roleRepository.findByName(role);
        if (roleEntity != null) {
            utilisateur.getRoles().remove(roleEntity);
            utilisateurRepository.save(utilisateur);
        } else {
            throw new IllegalArgumentException("Le rôle spécifié n'existe pas.");
        }
    }
}
