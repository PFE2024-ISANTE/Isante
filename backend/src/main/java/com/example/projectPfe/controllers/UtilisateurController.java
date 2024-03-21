package com.example.projectPfe.controllers;


import com.example.projectPfe.Services.UtilisateurService;
import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Utilisateur;
import com.example.projectPfe.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UserRepository userRepository ;

    private final UtilisateurService utilisateurService;


    public UtilisateurController(UserRepository userRepository, UtilisateurService utilisateurService) {
        this.userRepository = userRepository;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/byRole/{role}")
    public List<Utilisateur> getUtilisateursByRole(@PathVariable ERole role) {
        return utilisateurService.findByRole(role);
    }


    @GetMapping("/byMat/{mat}")
    public List<Utilisateur> getUtilisateursByRole(@PathVariable String mat) {
        return utilisateurService.findbyMat(mat);
    }

    @PostMapping("ajouterRole")
    public void ajouterRoleAUtilisateur(@RequestParam Integer utilisateurId, @RequestParam ERole role) {
        Utilisateur utilisateur = userRepository.findById(utilisateurId).orElse(null);
        if (utilisateur != null) {
            utilisateurService.affecterRole(utilisateur, role);
        }
    }

    @DeleteMapping("/{utilisateurId}/roles/{role}")
    public void supprimerRoleUtilisateur(@PathVariable Integer utilisateurId, @PathVariable ERole role) {
        Utilisateur utilisateur = userRepository.findById(utilisateurId)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun utilisateur trouvé avec cet ID : " + utilisateurId));

        utilisateurService.limiterRole(utilisateur, role);
    }

}
