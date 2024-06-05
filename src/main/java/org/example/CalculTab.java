package org.example;
import java.util.*;

/**
 * Somme des éléments d'un tableau de nombres décimaux
 */
public class CalculTab {
    private ArrayList<Double> tab;
    private int i;
    private int n = 0;
    private double sum = 0;
    private int lengthTab;
    private double minValue = 0.0;
    private double maxValue = 20.0;

    /** Permet de définir la taille du tableau */
    public CalculTab(int lengthTab){
        this.lengthTab = lengthTab;
        n = lengthTab;
        tab = new ArrayList<>();
    }

    /** Demande à l'utilisateur de rentrer tous les nombres dans le tableau */
    public ArrayList<Double> makeTab(){
        tab = new ArrayList<>();
        Scanner sc1 = new Scanner(System.in);
        for (i = 0; i < n; i++) {
            double value;
            while (true) {
                System.out.println("Veuillez entrer un nombre décimal (entre 0 et 20, avec jusqu'à 3 chiffres après la virgule) :");
                value = sc1.nextDouble();
                if (value >= minValue && value <= maxValue) {
                    break;
                } else {
                    System.out.println("Erreur: Le nombre doit être entre " + minValue + " et " + maxValue + ". Veuillez réessayer.");
                }
            }
            tab.add(value);
        }
        return tab;
    }

    /** Affiche tous les nombres du tableau */
    public void afficherTab(){
        System.out.println("Les éléments du tableau sont : ");
        for (i = 0; i < n; i++) {
            System.out.printf("%.3f\n", tab.get(i));
        }
    }

    /** Calcule la somme des nombres entrés dans le tableau */
    public double somme(){
        sum = 0;
        for (i = 0; i < n; i++) {
            sum += tab.get(i);
        }
        System.out.printf("La somme des éléments est égale à %.3f\n", sum);
        return sum;
    }

    /** Calcule la moyenne des nombres entrés dans le tableau */
    public double moyenne(){
        double moy = somme() / tab.size();
        System.out.printf("La moyenne des éléments est égale à %.3f\n", moy);
        return moy;
    }

    /** Calcule la médiane des nombres entrés dans le tableau */
    public double mediane(){
        Collections.sort(tab);
        double med;
        if (lengthTab % 2 == 0) {
            med = (tab.get(lengthTab / 2 - 1) + tab.get(lengthTab / 2)) / 2.0;
        } else {
            med = tab.get(lengthTab / 2);
        }
        System.out.printf("La médiane des éléments est égale à %.3f\n", med);
        return med;
    }

    @Override
    public String toString() {
        return "CalculTab{" +
                "tab=" + tab +
                ", lengthTab=" + lengthTab +
                '}';
    }

    public static void main(String[] args) {
        CalculTab calculTab = new CalculTab(5); // Example with 5 elements
        calculTab.makeTab();
        calculTab.afficherTab();
        calculTab.somme();
        calculTab.moyenne();
        calculTab.mediane();
    }
}
