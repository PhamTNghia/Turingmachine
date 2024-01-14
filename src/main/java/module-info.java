module com.example.turingmachine {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.turingmachine to javafx.fxml;
    exports com.example.turingmachine;
    exports com.example.turingmachine.TupelClasses;
    opens com.example.turingmachine.TupelClasses to javafx.fxml;
    exports com.example.turingmachine.ViewController;
    opens com.example.turingmachine.ViewController to javafx.fxml;
}