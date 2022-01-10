module com.mycompany.crudobjectdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.persistence;

    opens com.mycompany.crudobjectdb to javafx.fxml;
    opens models;
    exports com.mycompany.crudobjectdb;
}
