module com.example.i200444_i200518_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jetbrains.annotations;


    opens com.example.i200444_i200518_project to javafx.fxml;
    exports com.example.i200444_i200518_project;
}