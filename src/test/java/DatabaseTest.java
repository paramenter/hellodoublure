import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Database;

public class DatabaseTest {

    @Test
    void testValidEmail() {
        Database db = new Database();
        assertTrue(db.isValideEmail("test@example.com"));
        assertTrue(db.isValideEmail("user123@gmail.com"));
        assertFalse(db.isValideEmail("invalidEmail@"));
        assertFalse(db.isValideEmail("invalid.com"));
        assertFalse(db.isValideEmail("user@invalid."));
        assertFalse(db.isValideEmail(null));
    }

    @Test
    void testValidPassword() {
        Database db = new Database();
        assertTrue(db.isValideMDP("Password123!"));
        assertFalse(db.isValideMDP("weakpassword"));
        assertFalse(db.isValideMDP("Onlyletters"));
        assertFalse(db.isValideMDP("12345678"));
        assertFalse(db.isValideMDP("!NoDigits!"));
    }

    @Test
    void testAuthentication() {
        Database db = new Database();
        // Créer un utilisateur de test dans la base de données
        db.addStudent("Test", "User", "test@example.com", "2024-06-15", 3, 15.5, 14.0);

        // Tester l'authentification avec les bons identifiants
        assertTrue(db.authenticate("test@example.com", "Password123!"));

        // Tester l'authentification avec un mauvais email
        assertFalse(db.authenticate("wrong@example.com", "Password123!"));

        // Tester l'authentification avec un mauvais mot de passe
        assertFalse(db.authenticate("test@example.com", "wrongpassword"));

        // Tester l'authentification avec des informations manquantes
        assertFalse(db.authenticate("", ""));
    }
}
