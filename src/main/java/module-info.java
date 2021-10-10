module com.vmaffioli.jcolors {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens com.vmaffioli.jcolors to javafx.fxml;
    exports com.vmaffioli.jcolors;
}
