module com.scheduleapp.c195task1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    exports controller;
    opens controller to javafx.fxml;
    exports com.scheduleapp.c195task1;
    opens com.scheduleapp.c195task1 to javafx.fxml;
    exports database;
    opens database to javafx.fxml;
}