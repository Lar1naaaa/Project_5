module com.app.project_5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.app.project_5.controller to javafx.fxml;
    opens com.app.project_5.model to javafx.base;
    requires java.sql;

    exports com.app.project_5;
}