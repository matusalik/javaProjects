module com.mycompany.carrepairgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.carrepairgui.Controllers to javafx.fxml;
    exports com.mycompany.carrepairgui;
    exports com.mycompany.carrepairgui.Controllers;
    exports com.mycompany.carrepairgui.Model;
    requires lombok;
}
