package com.example.projectPfe.controllers;

import com.example.projectPfe.Services.Interface.UserService;
import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/{roleName}")
    public ResponseEntity<Utilisateur> ajouterUtilisateur(
            @RequestBody Utilisateur utilisateur,
            @PathVariable("roleName") String roleNameString) {

        Utilisateur newUser = userService.ajouterCompte(utilisateur, ERole.valueOf(roleNameString));
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/disable/{userId}")
    public ResponseEntity<String> desactiverCompte(@PathVariable int userId) {
        Utilisateur user = userService.desactiverCompte(userId);
        return ResponseEntity.status(HttpStatus.OK).body("Compte utilisateur désactivé avec succès");
    }

    @PutMapping("/able/{userId}")
    public ResponseEntity<String> activerCompte(@PathVariable int userId) {
        Utilisateur user = userService.activerCompte(userId);
        return ResponseEntity.status(HttpStatus.OK).body("Compte utilisateur activé avec succès");
    }

    @DeleteMapping("/{id}")
    public void deleteAdhrent(@PathVariable int id) {
       userService.SupprimerUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable int id) {
        Optional<Utilisateur> userOptional = userService.findUserById(id);
        return userOptional.map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        List<Utilisateur> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

}
