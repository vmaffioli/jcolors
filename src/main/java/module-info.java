module com.vmaffioli.jcolors {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vmaffioli.jcolors to javafx.fxml;
    exports com.vmaffioli.jcolors;
}
