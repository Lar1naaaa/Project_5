package com.app.project_5.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/project5";
        String user = "root";
        String password = "tadar2008";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Подключение к базе данных прошло успешно!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД: " + e.getMessage());
            throw e;
        }
    }
    public static void main(String[] args) {
        System.out.println("Try connection...");
        try (Connection connection = Database.getConnection()){
            if (connection != null && !connection.isClosed()) {
                System.out.println("Success connection: " + connection.getMetaData());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}