module com.scheduleapp.c195task1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.scheduleapp.c195task1.controller;
    opens com.scheduleapp.c195task1.controller to javafx.fxml;
    exports com.scheduleapp.c195task1;
    opens com.scheduleapp.c195task1 to javafx.fxml;
}