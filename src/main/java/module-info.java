module com.scheduleapp.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    exports controller;
    opens controller to javafx.fxml;

    exports com.scheduleapp.main;
    opens com.scheduleapp.main to javafx.fxml;

    exports model;
    opens model to javafx.base;

    exports database;
    opens database to javafx.fxml;
}