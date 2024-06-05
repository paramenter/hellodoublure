package org.example;

import java.util.regex.Pattern;

public class UtilisateurTab {
    private String prenom;
    private String nom;
    private String email;

    public UtilisateurTab(String prenom, String nom, String email) throws IllegalArgumentException {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email non valide");
        }else {
            System.out.println("E-mail valide");
        }
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    @Override
    public String toString() {
        return "Prénom: " + prenom + ", Nom: " + nom + ", Email: " + email;
    }
}