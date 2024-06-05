package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object;

public class CalculTabTest {

    private CalculTab calculTab;

    @BeforeEach
    public void setUp() {
        calculTab = new CalculTab(5);
    }

    @Test
    public void testMakeTab() {
        ArrayList<Integer> expectedTab = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        calculTab.makeTab().addAll(expectedTab);
        //assertThat(calculTab.makeTab()).equals(expectedTab);
    }

    @Test
    public void testAfficherTab() {
        ArrayList<Integer> expectedTab = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        calculTab.makeTab().addAll(expectedTab);
        calculTab.afficherTab();
    }

    @Test
    public void testSomme() {
        ArrayList<Integer> tabValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        calculTab.makeTab().addAll(tabValues);
        int sum = calculTab.somme();
        assertThat(sum).equals(15);
    }

    @Test
    public void testMoyenne() {
        ArrayList<Integer> tabValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        calculTab.makeTab().addAll(tabValues);
        double average = calculTab.moyenne();
        assertThat(average).equals(3.0);
    }

    @Test
    public void testMediane() {
        ArrayList<Integer> tabValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        calculTab.makeTab().addAll(tabValues);
        double median = calculTab.mediane();
        assertThat(median).equals(3.0);
    }

    private Object assertThat(double median) {
        return null;
    }
}
