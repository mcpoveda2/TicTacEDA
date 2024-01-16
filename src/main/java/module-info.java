module ec.edu.espol.tictactoegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.tictactoegame to javafx.fxml;
    exports ec.edu.espol.tictactoegame;
}
