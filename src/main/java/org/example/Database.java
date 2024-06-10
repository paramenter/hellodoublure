package org.example;

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

    public boolean authenticate() {
        if (!isValideEmail(this.email)) {
            System.out.println("Invalid email format.");
            return false;
        }

        if (!isValideMDP(this.mdp)) {
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
