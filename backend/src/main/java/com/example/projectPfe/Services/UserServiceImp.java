package com.example.projectPfe.Services;

import com.example.projectPfe.Exceptions.EmailAlreadyExistsException;
import com.example.projectPfe.Exceptions.UserNotFoundException;
import com.example.projectPfe.Services.Interface.UserService;
import com.example.projectPfe.models.ERole;
import com.example.projectPfe.models.Role;
import com.example.projectPfe.models.Utilisateur;
import com.example.projectPfe.repository.RoleRepository;
import com.example.projectPfe.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UtilisateurRepository userRepository;
    private final RoleRepository roleRepository;
    private final JavaMailSender emailSender;

    @Override
    public Utilisateur ajouterCompte(Utilisateur user , ERole roleName) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("L'email spécifié est déjà utilisé par un autre utilisateur.");
        }

        Role role = roleRepository.findByName(ERole.valueOf(String.valueOf(roleName)))
                .orElseThrow(() -> new UserNotFoundException("Le rôle spécifié n'existe pas."));
        user.getRoles().add(role);
        Utilisateur savedUser = userRepository.save(user);
        sendAccountDetailsEmail(savedUser.getEmail(), savedUser.getPassword());
        return savedUser;
    }

    public Optional<Utilisateur> findUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Utilisateur desactiverCompte(int userId) {
        Utilisateur user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur non trouvé avec l'ID : " + userId));

        user.desactiverCompte();

        return userRepository.save(user);
    }

    @Override
    public Utilisateur activerCompte(int userId) {
        Utilisateur user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur non trouvé avec l'ID : " + userId));

        user.activerCompte();

        return userRepository.save(user);    }

    @Override
    public boolean SupprimerUser(int userId) {
        boolean exist = userRepository.existsById(userId);

        if (!exist) {
            return false ;
        }

        else {
            userRepository.deleteById(userId);
            return true ;

        }
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }


    private void sendAccountDetailsEmail(String recipientEmail, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hbaieb.houssem999@gmail.com");
        message.setTo(recipientEmail);
        message.setSubject("Your Account Details");
        message.setText("Your account has been successfully created.\n"
                + "Email: " + recipientEmail + "\n"
                + "Password: " + password);
        emailSender.send(message);
    }


    }

