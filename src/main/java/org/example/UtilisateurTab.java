package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UtilisateurTab {
    private String prenom;
    private String nom;
    private String email;
    private String date;
    private int nbEleve;
    private double moy;
    private double med;

    public UtilisateurTab(String prenom, String nom, String email, String date) throws IllegalArgumentException {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email non valide");
        }else {
            System.out.println("E-mail valide");
        }
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.date = date;
        entreeNote();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public void entreeNote(){
        Scanner sc = new Scanner(System.in);
        int taille = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Veuillez entrer la taille du tableau : ");
            if (sc.hasNextInt()) {
                taille = sc.nextInt();
                if (taille > 0) {
                    validInput = true;
                } else {
                    System.out.println("La taille du tableau doit être un nombre entier positif. Veuillez réessayer.");
                }
            } else {
                System.out.println("Entrée non valide. Veuillez entrer un nombre entier.");
                sc.next();
            }
        }
        CalculTab calculTab = new CalculTab(taille);
        calculTab.makeTab();
        nbEleve = taille;
        moy = calculTab.moyenne();
        med = calculTab.mediane();
    }

    @Override
    public String toString() {
        return "UtilisateurTab{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                ", nbEleve=" + nbEleve +
                ", moy=" + moy +
                ", med=" + med +
                '}';
    }
}