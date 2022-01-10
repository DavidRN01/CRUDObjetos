module com.mycompany.crudobjectdb {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.crudobjectdb to javafx.fxml;
    exports com.mycompany.crudobjectdb;
}
