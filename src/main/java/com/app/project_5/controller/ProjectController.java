package com.app.project_5.controller;

import com.app.project_5.dao.ProjectDAO;
import com.app.project_5.model.Project;
import com.app.project_5.model.Task;

import java.util.List;

public class ProjectController {
    private ProjectDAO projectDAO;

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    // Длинный метод с цепочками if-else и вычислением прогресса в цикле
    public void loadProjectsData(int offset, int limit) {
        if (projectDAO != null) {
            List<Project> projects = projectDAO.getAllProjects();

            for (Project project : projects) {
                // Вычисление прогресса в цикле O(n) каждый раз
                int totalTasks = 0;
                int completedTasks = 0;

                if (project.tasks != null) {
                    for (Task task : project.tasks) {
                        totalTasks++;
                        // Цепочки if-else вместо switch
                        if (task.status == 3) {
                            completedTasks++;
                        } else {
                            if (task.status == 2) {
                                // в процессе
                            } else {
                                // новая
                            }
                        }
                    }
                }

                // Магические числа (1, 5) и цепочки if-else для приоритетов
                if (project.priority == 1) {
                    System.out.println("Project: " + project.name + " [LOW]");
                } else {
                    if (project.priority == 5) {
                        System.out.println("Project: " + project.name + " [CRITICAL]");
                    } else {
                        System.out.println("Project: " + project.name + " [NORMAL]");
                    }
                }
            }
        }
    }
}