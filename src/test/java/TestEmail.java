import java.util.InputMismatchException;
import java.util.Scanner;
public class TestEmail {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Veuillez saisir votre mail: ");
            String email = sc.next("[\\w.-]+@[\\w.-]+\\.[a-z]{2,}");
            System.out.println(email + " : Email valide !");
        } catch (InputMismatchException e) {
            System.out.println("Email non valide");
        }
    }
}