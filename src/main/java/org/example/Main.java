package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        calculTab.afficherTab();
        calculTab.sum();
        double moyenne = calculTab.moy();
        System.out.println("La moyenne des éléments est égale à " + moyenne);
        double mediane = calculTab.med();
        System.out.println("La médiane des éléments est égale à " + mediane);

        System.out.println("/////////////////////UtilisateurTab/////////////////////");
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrée le prénom :");
        String prenom = sc.next();
        System.out.println("Entrée le nom :");
        String nom = sc.next();
        System.out.println("Entrée le mail :");
        String mail = sc.next();
        UtilisateurTab user = new UtilisateurTab(prenom, nom, mail);
        System.out.println(user);
    }
}
