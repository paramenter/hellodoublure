import org.example.CalculTab;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculTabTest {


    private CalculTab calculTab;

    @BeforeEach
    public void setUp() {
        calculTab = new CalculTab(5);
    }

    @Test
    public void testMakeTab() {
        CalculTab calculTab = new CalculTab(3);
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(1., 2., 3.));
        ArrayList<Double> actual = calculTab.makeTab();
        assertEquals(expected, actual, "OK");
    }

    @Test
    public void testAfficherTab() {
        ArrayList<Double> expectedTab = new ArrayList<>(Arrays.asList(1., 2., 3., 4., 5.));
        calculTab.makeTab().addAll(expectedTab);
        calculTab.afficherTab();
    }

    @Test
    public void testSomme() {
        ArrayList<Double> tabValues = new ArrayList<>(Arrays.asList(1., 2., 3., 4., 5.));
        calculTab.makeTab().addAll(tabValues);
        double sum = calculTab.somme();
        assertThat(sum).equals(15.);
    }

    @Test
    public void testMoyenne() {
        ArrayList<Double> tabValues = new ArrayList<>(Arrays.asList(1., 2., 3., 4., 5.));
        calculTab.makeTab().addAll(tabValues);
        double average = calculTab.moyenne();
        assertThat(average).equals(3.0);
    }

    @Test
    public void testMediane() {
        ArrayList<Double> tabValues = new ArrayList<>(Arrays.asList(1., 2., 3., 4., 5.));
        calculTab.makeTab().addAll(tabValues);
        double median = calculTab.mediane();
        assertThat(median).equals(3.0);
    }

    private Object assertThat(double median) {
        return null;
    }
}
