package org.example;

import java.sql.*;
import java.util.regex.Pattern;

public class Database {
    private String email;
    private String mdp;
    private Connection connection;

    public Database(){
        this.connection = getConnection();
    }

    private Connection getConnection() {
        try {
            // Charger le driver H2
            Class.forName("org.h2.Driver");
            // Établir la connexion au serveur H2
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (ClassNotFoundException e) {
            System.out.println("H2 Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return null;
    }

    public boolean isValideEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }

    public boolean isValideMDP(String mdp) {
        if (mdp.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char ch : mdp.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public boolean authenticate(String email, String mdp) {
        if (!isValideEmail(email)) {
            System.out.println("Invalid email format.");
            return false;
        }

        if (!isValideMDP(mdp)) {
            System.out.println("Password is not strong enough.");
            return false;
        }

        if (this.connection == null) {
            System.out.println("Failed to connect to the database.");
            return false;
        }

        try {
            String query = "SELECT COUNT(*) FROM USERS WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, mdp);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void displayStudents() {
        if (this.connection == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                System.out.println(
                        "Nom: " + rs.getString("nom") +
                                ", Prénom: " + rs.getString("prenom") +
                                ", Email: " + rs.getString("mail") +
                                ", Date: " + rs.getDate("date") +
                                ", Nombre de notes: " + rs.getInt("nbNote") +
                                ", Moyenne: " + rs.getDouble("moyenne") +
                                ", Médiane: " + rs.getDouble("mediane")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String nom, String prenom, String mail, String date, int nbNote, double moyenne, double mediane) {
        if (this.connection == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        String query = "INSERT INTO STUDENTS (nom, prenom, mail, date, nbNote, moyenne, mediane) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, mail);
            pstmt.setDate(4, java.sql.Date.valueOf(date));
            pstmt.setInt(5, nbNote);
            pstmt.setDouble(6, moyenne);
            pstmt.setDouble(7, mediane);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Database db = new Database();
        // Ajouter un nouvel étudiant
        db.addStudent("nouveau", "etudiant", "nouveau@etudiant.com", "2024-06-15", 3, 15.5, 14.0);

        // Affiche les étudiants après ajout
        db.displayStudents();
    }
}
