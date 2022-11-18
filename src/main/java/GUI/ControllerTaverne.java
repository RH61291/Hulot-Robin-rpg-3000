package GUI;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



public class ControllerTaverne extends Core {

    @FXML
    private Button bouton1;
    @FXML
    private Button bouton2;
    @FXML
    private Button bouton3;
    @FXML
    private Button bouton4;
    @FXML
    private Text énoncé;

    @FXML
    void choix1(MouseEvent event) {
        setNombre_héros(1);
        System.out.println(nombre_héros);

        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé.setVisible(false);
    }

    @FXML
    void choix2(MouseEvent event) {
        setNombre_héros(2);
        System.out.println(nombre_héros);

        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé.setVisible(false);
    }

    @FXML
    void choix3(MouseEvent event) {
        setNombre_héros(3);
        System.out.println(nombre_héros);

        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé.setVisible(false);
    }

    @FXML
    void choix4(MouseEvent event) {
        setNombre_héros(4);
        System.out.println(nombre_héros);

        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé.setVisible(false);
    }



}
