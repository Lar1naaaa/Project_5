module com.app.project_5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.app.project_5 to javafx.fxml;
    exports com.app.project_5;
}