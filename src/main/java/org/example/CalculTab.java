package org.example;
import java.util.*;
// Sommedeséléments d'un tableau d'entiers
public class CalculTab {
    private ArrayList<Integer> tab;
    private int i;
    private int n = 0;
    private int Sum = 0;
    private int lenghtTab;
    /**Permet de definir la taille du tableau */
    public CalculTab(int lenghtTab){
        this.lenghtTab = lenghtTab;
        n = lenghtTab;
        tab = new ArrayList<>();
    }
    /**Demande a utilisateur de rentrer tout les note dans le tableau */
    public ArrayList<Integer> makeTab(){
        tab = new ArrayList<>();
        for (i = 0; i < n; i++) {
            System.out.println("Veuillez entrer un nombre");
            Scanner sc1 = new Scanner(System.in);
            tab.add(sc1.nextInt());
        }
        return tab;
    }
    /** Affiche tout les note du tableau */
    public void afficherTab(){
        System.out.println("Les élements de tableau sont : ");
        for (i = 0; i < n; i++) {
            System.out.println(tab.get(i));
        }
    }
    /**Calcule la somme des note entrée dans le tableau */
    public int somme(){
        Sum = 0;
        for (i = 0; i < n; i++) {
            Sum+=tab.get(i);
        }
        System.out.println("La somme des éléments est égale à " + Sum);
        return Sum;
    }
    /**Calcule la moyenne des note entrée dans le tableau */
    public double moyenne(){
        return (double) somme() / tab.size();
    }

    /**Calcule la mediane des note entrée dans le tableau */
    public double mediane(){
        Collections.sort(tab);
        if (lenghtTab % 2 == 0) {
            return (tab.get(lenghtTab / 2 - 1) + tab.get(lenghtTab / 2)) / 2.0;
        } else {
            return tab.get(lenghtTab / 2);
        }
    }

    @Override
    public String toString() {
        return "CalculTab{" +
                "tab=" + tab +
                ", lenghtTab=" + lenghtTab +
                '}';
    }
}