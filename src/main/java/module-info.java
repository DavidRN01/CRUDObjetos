module com.mycompany.crudobjectdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.persistence;
    requires java.sql;

    opens com.mycompany.crudobjectdb to javafx.fxml, java.sql;
    opens models;
    exports com.mycompany.crudobjectdb;
}
