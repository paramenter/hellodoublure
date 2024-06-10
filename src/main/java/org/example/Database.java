package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private String email;
    private String mdp;
    private Connection connection;

    public Database(String email, String mdp){
        this.email = email;
        this.mdp = mdp;
        this.connection = getConnection();
    }

    private Connection getConnection() {
        try {
            // Charger le driver H2
            Class.forName("org.h2.Driver");
            // Établir la connexion
            return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isValideEmail(String email) {
        // Utiliser une expression régulière pour valider l'email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public boolean isValideMDP(String mdp) {
        // Vérifier si le mot de passe est assez fort
        if (mdp.length() < 8) return false; // Minimum 8 caractères
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char ch : mdp.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public boolean authenticate() {
        if (!isValideEmail(this.email)) {
            System.out.println("Invalid email format.");
            return false;
        }

        if (!isValideMDP(this.mdp)) {
            System.out.println("Password is not strong enough.");
            return false;
        }

        // Vérifier les informations d'identification dans la base de données
        try {
            String query = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.email);
            preparedStatement.setString(2, this.mdp);
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

    public static void main(String[] args) {
        Database db = new Database("test@example.com", "Password123!");
        if (db.authenticate()) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
