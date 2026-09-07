package com.app.project_5.controller;

import com.app.project_5.config.Database;
import com.app.project_5.dao.ProjectDAO;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class MainController {

    @FXML private ProjectController projectViewController; // Встроенный контроллер ProjectView

    @FXML
    public void initialize() {
        try {
            ProjectDAO projectDAO = new ProjectDAO(Database.getConnection());
            if (projectViewController != null) {
                projectViewController.setProjectDAO(projectDAO);
                projectViewController.loadProjectsData(0, 20); // Загрузка 1 страницы
            }
        } catch (SQLException e) {
            e.printStackTrace(); //
        }
    }
}