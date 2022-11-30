package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerStart extends Core {
    @FXML
    private Button bouton1;

    @FXML
    void enter(MouseEvent event) throws IOException {
        créaFile();
        Stage stage = (Stage) bouton1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Taverne.fxml"));
        stage.setScene(new Scene(root));
    }

}
