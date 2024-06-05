package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UtilisateurTab user = new UtilisateurTab();
        Scanner scan = new Scanner(System.in);

        boolean continueEnteringNotes = true;

        while (continueEnteringNotes) {
            System.out.println("Voulez-vous entrer des notes? (oui/non)");
            String response = scan.next();
            if (response.equalsIgnoreCase("oui")) {
                user.entreeNote();

                boolean done = false;
                while (!done) {
                    System.out.println("Voulez-vous stocker les notes? (oui/non)");
                    response = scan.next();

                    if (response.equalsIgnoreCase("oui")) {
                        user.stockerNote();
                        done = true;
                    } else {
                        System.out.println("Voulez-vous re-entrer des notes? (oui/non)");
                        response = scan.next();
                        if (response.equalsIgnoreCase("oui")) {
                            user.entreeNote();
                        } else {
                            done = true;
                        }
                    }
                }
            } else {
                continueEnteringNotes = false;
                System.out.println("Projet terminé.");
            }
        }

        scan.close();
    }
}
