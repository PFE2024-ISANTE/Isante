package com.example.projectPfe.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private int id;
    private String nom;
    private String email;
    private String password;

    private List<String> roles;

    public  JwtResponse(String accessToken, int id, String email, String nom, String password, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.password= password;
        this.roles = roles;

    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String username) {
        this.nom = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }
}
