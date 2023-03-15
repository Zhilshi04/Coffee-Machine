module com.coffeemachine.coffeemachineguifx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.coffeemachine.coffeemachineguifx to javafx.fxml;
    exports com.coffeemachine.coffeemachineguifx;
}