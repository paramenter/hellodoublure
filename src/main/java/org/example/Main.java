package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = 0;
        boolean boucle = true;
        do {
            try {
                System.out.println("Entrée le nombre d'étudiants");
                len = scan.nextInt();
                boucle = false;
            }catch (Exception e){
                System.out.println("Entrée un entier");
                boucle = true;
            }
            System.out.println(boucle);
        }while (len < 0 && boucle);
        System.out.println(len);
        CalculTab cal = new CalculTab(len);
        cal.makeTab();
        cal.afficherTab();
        cal.sum();
        cal.med();
        cal.moy();
    }
}
