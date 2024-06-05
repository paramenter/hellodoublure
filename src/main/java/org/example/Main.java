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
    }
}
