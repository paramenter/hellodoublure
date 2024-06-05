package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrée le prénom :");
        String prenom = scan.next();
        System.out.println("Entrée le nom :");
        String nom = scan.next();
        System.out.println("Entrée le mail :");
        String mail = scan.next();
        System.out.println("Entrée la date :");
        String date = scan.next();
        UtilisateurTab user = new UtilisateurTab(prenom, nom, mail, date);
        System.out.println(user);
        user.stockerNote();
    }
}
