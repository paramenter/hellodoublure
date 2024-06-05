package org.example;
import java.util.*;
// Sommedeséléments d'un tableau d'entiers
public class CalculTab {
    private ArrayList<Integer> tab;
    private int i;
    private int n = 0;
    private int Sum = 0;
    private int lenghtTab;
    public CalculTab(int lenghtTab){
        this.lenghtTab = lenghtTab;
        n = lenghtTab;
        tab = new ArrayList<>();
    }
    public ArrayList<Integer> makeTab(){
        tab = new ArrayList<>();
        System.out.println("****DEBUT PROGRAMME****");
        for (i = 0; i < n; i++) {
            System.out.println("Veuillez entrer un nombre");
            Scanner sc1 = new Scanner(System.in);
            tab.add(sc1.nextInt());
        }
        return tab;
    }
    public void afficherTab(){
        System.out.println("Les élements de tableau sont : ");
        for (i = 0; i < n; i++) {
            System.out.println(tab.get(i));
        }
    }
    public int sum(){
        Sum = 0;
        for (i = 0; i < n; i++) {
            Sum+=tab.get(i);
        }
        System.out.println("La somme des éléments est égale à " + Sum);
        return Sum;
    }
    public double moy(){
        return (double) sum() / tab.size();
    }
    public double med(){
        Collections.sort(tab);
        if (lenghtTab % 2 == 0) {
            return (tab.get(lenghtTab / 2 - 1) + tab.get(lenghtTab / 2)) / 2.0;
        } else {
            return tab.get(lenghtTab / 2);
        }
    }
}