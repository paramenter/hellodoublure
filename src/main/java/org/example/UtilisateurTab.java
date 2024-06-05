package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;


public class UtilisateurTab {
    private String prenom;
    private String nom;
    private String email;
    private String date;
    private int nbEleve;
    private double moy;
    private double med;


    public UtilisateurTab() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrée le prénom :");
        this.prenom = scan.next();

        System.out.println("Entrée le nom :");
        this.nom = scan.next();

        while (true) {
            System.out.println("Entrée le mail :");
            this.email = scan.next();
            if (!isValidEmail(this.email)) {
                System.out.println("Email non valide. Veuillez réessayer.");
            } else {
                System.out.println("E-mail valide");
                break;
            }
        }

        while (true) {
            System.out.println("Entrée la date (format jj/mm/aaaa) :");
            this.date = scan.next();
            if (!isValidDate(this.date)) {
                System.out.println("Date non valide. Veuillez réessayer.");
            } else {
                System.out.println("Date valide");
                break;
            }
        }
    }
    /** Verifie si email est valide*/
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    /** Verifie si date est valide*/
    public static boolean isValidDate(String date) {
        String dateRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(dateRegex);
        return pattern.matcher(date).matches();
    }
    /**  Le prof entre les notes des eleves */
    public void entreeNote() {
        Scanner sc = new Scanner(System.in);
        int taille = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Veuillez entrer la taille du tableau (doit être un nombre entier positif et inférieur ou égal à 50) : ");
            if (sc.hasNextInt()) {
                taille = sc.nextInt();
                if (taille > 0 && taille <= 50) {
                    validInput = true;
                } else {
                    System.out.println("La taille du tableau doit être un nombre entier positif et inférieur ou égal à 50. Veuillez réessayer.");
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

    public void stockerNote(){
        String filePath = "output.csv";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append("\n" + nom + ";" + prenom + ";" + email + ";" + date + ";" + nbEleve + ";" + moy + ";" + med);
            System.out.println("Nouvelles données ajoutées avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
        }
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