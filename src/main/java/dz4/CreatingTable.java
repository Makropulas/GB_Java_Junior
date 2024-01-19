package dz4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatingTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/";
        String user = "root";
        String password = "password";

        String databaseName = "ScoolDB";
        String tableDeclaration = "Courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(45), duration INT)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Создание базы данных
            createDatabase(connection, databaseName);
            System.out.println("Database created successfully");

            // Использование базы данных
            useDatabase(connection, databaseName);
            System.out.println("Use database successfully");

            // Создание таблицы
            createTable(connection, tableDeclaration);
            System.out.println("Create table successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createDatabase(Connection connection, String databaseName) throws SQLException {
        String createDatabaseSQL = String.format("CREATE DATABASE IF NOT EXISTS %s;", databaseName);
        PreparedStatement statement = connection.prepareStatement(createDatabaseSQL);
        statement.execute();
    }

    private static void useDatabase(Connection connection, String databaseName) throws SQLException {
        String useDatabaseSQL = String.format("USE %s;", databaseName);
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection, String tableDeclaration) throws SQLException {
        String createTableSQL = String.format("CREATE TABLE IF NOT EXISTS %s;", tableDeclaration);
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }
}
