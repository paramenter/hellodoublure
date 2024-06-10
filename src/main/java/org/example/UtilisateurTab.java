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
            System.out.println("Entrée la date (format aaaa-mm-jj) :");
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
        String dateRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
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
        Database db = new Database();
        Scanner scan = new Scanner(System.in);
        String email = "", mdp = "";
        int i = 0;
        do{
            if (i == 3) {
                System.out.println("Trop erreure mdp");
                return;
            }
            System.out.println("Entrer mail");
            email = scan.nextLine();
            System.out.println("Entrer mdp");
            mdp = scan.nextLine();
            i++;
        }while (!db.authenticate(email, mdp));
        db.addStudent(nom, prenom, this.email, date, nbEleve, moy, med);
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