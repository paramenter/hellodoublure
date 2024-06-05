package org.example;
import java.util.*;
// Sommedeséléments d'un tableau d'entiers
public class CalculTab {
    private int[] tab;
    private int i;
    private int n = 0;
    private int Sum = 0;
    private int lenghtTab;
    public CalculTab(int lenghtTab){
        this.lenghtTab = lenghtTab;
        n = lenghtTab;
        tab = new int[lenghtTab];
    }
    public int[] makeTab(){
        System.out.println("****DEBUT PROGRAMME****");
        for (i = 0; i < n; i++) {
            System.out.println("Veuillez entrer un nombre");
            Scanner sc1 = new Scanner(System.in);
            tab[i] = sc1.nextInt();
        }
        return tab;
    }
    public void afficherTab(){
        System.out.println("Les élements de tableau sont : ");
        for (i = 0; i < n; i++) {
            System.out.println(tab[i]);
        }
    }
    public int sum(){
        Sum = 0;
        for (i = 0; i < n; i++) {
            Sum+=tab[i];
        }
        System.out.println("La somme des éléments est égale à " + Sum);
        return Sum;
    }
    public double moy(){
        return (double) sum() / tab.length;
    }
    public double med(){
        Arrays.sort(tab);
        if (lenghtTab % 2 == 0) {
            return (tab[lenghtTab / 2 - 1] + tab[lenghtTab / 2]) / 2.0;
        } else {
            return tab[lenghtTab / 2];
        }
    }
}