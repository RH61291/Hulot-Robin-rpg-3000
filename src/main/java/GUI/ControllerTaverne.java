package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jeu_console.Combattant.Hero.Hero;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ControllerTaverne extends Core {
    public Hero[] listehéros;

    @FXML
    private Button bouton1;
    @FXML
    private Button bouton2;
    @FXML
    private Button bouton3;
    @FXML
    private Button bouton4;
    @FXML
    private Text énoncé1;
    @FXML
    private Text énoncé2;
    @FXML
    private Button sortieTav;
    @FXML
    private Button GHealer;
    @FXML
    private Button GHunter;
    @FXML
    private Button GMAge;
    @FXML
    private Button GWarrior;
    @FXML
    private Label label1;
    @FXML
    private Label label2;


    @FXML
    void choix1(MouseEvent event) throws FileNotFoundException {
        ecriture("\n1");

        listehéros = new Hero[1];

        ecriture("\nnombre ennemis");
        ecriture("\n1");
        ecriture("\nliste classe");


        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé1.setVisible(false); //les boutons des autres choix (nombre héros)

        énoncé2.setVisible(true);
        GHealer.setVisible(true);
        GWarrior.setVisible(true); //les bouton de choix de classe
        GMAge.setVisible(true);
        GHunter.setVisible(true);
        writeData("/" + lecture(2), 750, 210, label1);
        writeData("1", 740, 210, label2); //le nombre de classe à choisir en cour

    }

    @FXML
    void choix2(MouseEvent event) throws FileNotFoundException {
        ecriture("\n2");

        listehéros = new Hero[2];

        ecriture("\nnombre ennemis");
        ecriture("\n2");
        ecriture("\nliste classe");

        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé1.setVisible(false);

        énoncé2.setVisible(true);
        GHealer.setVisible(true);
        GWarrior.setVisible(true);
        GMAge.setVisible(true);
        GHunter.setVisible(true);
        writeData("/" + lecture(2), 750, 210, label1);
        writeData("1", 740, 210, label2);
    }

    @FXML
    void choix3(MouseEvent event) throws FileNotFoundException {
        ecriture("\n3");

        listehéros = new Hero[3];

        ecriture("\nnombre ennemis");
        ecriture("\n3");
        ecriture("\nliste classe");

        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé1.setVisible(false);

        énoncé2.setVisible(true);
        GHealer.setVisible(true);
        GWarrior.setVisible(true);
        GMAge.setVisible(true);
        GHunter.setVisible(true);
        writeData("/" + lecture(2), 750, 210, label1);
        writeData("1", 740, 210, label2);

    }

    @FXML
    void choix4(MouseEvent event) throws FileNotFoundException {
        ecriture("\n4");

        listehéros = new Hero[4];

        ecriture("\nnombre ennemis");
        ecriture("\n4");
        ecriture("\nliste classe");

        bouton1.setVisible(false);
        bouton2.setVisible(false);
        bouton3.setVisible(false);
        bouton4.setVisible(false);
        énoncé1.setVisible(false);

        énoncé2.setVisible(true);
        GHealer.setVisible(true);
        GWarrior.setVisible(true);
        GMAge.setVisible(true);
        GHunter.setVisible(true);
        writeData("/" + lecture(2), 750, 210, label1);
        writeData("1", 740, 210, label2);

    }


    @FXML
    void genHealer(MouseEvent event) throws FileNotFoundException {
        if (lecture(2).equals("1")) { //si 1 seul héros
            listehéros[0] = new Hero(); //créer la liste et initialisation
            ecriture("\nhealer"); //liste la classe

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            label2.setVisible(false);
            label1.setVisible(false);
            sortieTav.setVisible(true);
        }

        if (lecture(2).equals("2")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 1) { //héros en dernière position
                        listehéros[1] = new Hero();
                        ecriture(" healer");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 1) {
                        listehéros[i] = new Hero(); //héros se trouvant avant, permet d'avoir l'odre des choix qui est l'odre de la liste des classe
                        ecriture("\nhealer");
                        a = false;
                        writeData("2", 740, 210, label2);
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("3")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 2) {
                        listehéros[2] = new Hero();
                        ecriture(" healer");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listehéros[i] = new Hero();
                        a = false;
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                            ecriture(" healer");
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nhealer");
                        }
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("4")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 3) {
                        listehéros[3] = new Hero();
                        ecriture(" healer");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 3) {
                        listehéros[i] = new Hero();
                        a = false;
                        if (i == 2) {
                            writeData("4", 740, 210, label2);
                            ecriture(" healer");
                        }
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                            ecriture(" healer");
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nhealer");
                        }
                    }
                }
                i += 1;
            }

        }

    }

    @FXML
    void genHunter(MouseEvent event) throws FileNotFoundException {
        if (lecture(2).equals("1")) {
            listehéros[0] = new Hero();
            ecriture("\nhunter");

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            label2.setVisible(false);
            label1.setVisible(false);
            sortieTav.setVisible(true);
        }

        if (lecture(2).equals("2")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 1) {
                        listehéros[1] = new Hero();
                        ecriture(" hunter");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 1) {
                        listehéros[i] = new Hero();
                        ecriture("\nhunter");
                        a = false;
                        writeData("2", 740, 210, label2);
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("3")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 2) {
                        listehéros[2] = new Hero();
                        ecriture(" hunter");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listehéros[i] = new Hero();
                        ecriture(" hunter");
                        a = false;
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nhunter");
                        }
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("4")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 3) {
                        listehéros[3] = new Hero();
                        ecriture(" hunter");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 3) {
                        listehéros[i] = new Hero();
                        a = false;
                        if (i == 2) {
                            writeData("4", 740, 210, label2);
                            ecriture(" hunter");
                        }
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                            ecriture(" hunter");
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nhunter");
                        }
                    }
                }
                i += 1;
            }

        }
    }

    @FXML
    void genMage(MouseEvent event) throws FileNotFoundException {
        if (lecture(2).equals("1")) {
            listehéros[0] = new Hero();
            ecriture("\nmage");

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            label2.setVisible(false);
            label1.setVisible(false);
            sortieTav.setVisible(true);
        }

        if (lecture(2).equals("2")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 1) {
                        listehéros[1] = new Hero();
                        ecriture(" mage");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);

                    }
                    if (i != 1) {
                        listehéros[i] = new Hero();
                        ecriture("\nmage");
                        a = false;
                        writeData("2", 740, 210, label2);
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("3")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 2) {
                        listehéros[2] = new Hero();
                        ecriture(" mage");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listehéros[i] = new Hero();
                        a = false;
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                            ecriture(" mage");
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nmage");
                        }
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("4")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 3) {
                        listehéros[3] = new Hero();
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                        ecriture(" mage");
                    }
                    if (i != 3) {
                        listehéros[i] = new Hero();
                        a = false;
                        if (i == 2) {
                            writeData("4", 740, 210, label2);
                            ecriture(" mage");
                        }
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                            ecriture(" mage");
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nmage");
                        }
                    }
                }
                i += 1;
            }

        }
    }

    @FXML
    void genWarrior(MouseEvent event) throws FileNotFoundException {
        if (lecture(2).equals("1")) {
            ecriture("\nwarrior");
            listehéros[0] = new Hero();

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            label2.setVisible(false);
            label1.setVisible(false);
            sortieTav.setVisible(true);

        }

        if (lecture(2).equals("2")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 1) {
                        ecriture(" warrior");
                        listehéros[1] = new Hero();
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);

                    }
                    if (i != 1) {
                        ecriture("\nwarrior");
                        listehéros[i] = new Hero();
                        a = false;
                        writeData("2", 740, 210, label2);
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("3")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 2) {
                        listehéros[2] = new Hero();
                        ecriture(" warrior");
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listehéros[i] = new Hero();
                        a = false;
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                            ecriture(" warrior");
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nwarrior");
                        }
                    }
                }
                i += 1;
            }

        }

        if (lecture(2).equals("4")) {
            Boolean a = true;
            int i = 0;
            while (a) {

                if (listehéros[i] == null) {
                    if (i == 3) {
                        ecriture(" warrior");
                        listehéros[i] = new Hero();
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        label2.setVisible(false);
                        label1.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 3) {
                        listehéros[i] = new Hero();
                        a = false;
                        if (i == 2) {
                            writeData("4", 740, 210, label2);
                            ecriture(" warrior");
                        }
                        if (i == 1) {
                            writeData("3", 740, 210, label2);
                            ecriture(" warrior");
                        }
                        if (i == 0) {
                            writeData("2", 740, 210, label2);
                            ecriture("\nwarrior");
                        }
                    }
                }
                i += 1;
            }

        }
    }

    @FXML
    void entDungeon(MouseEvent event) throws IOException {
        Stage stage = (Stage) sortieTav.getScene().getWindow(); //charge une nouvelle scene
        Parent root = FXMLLoader.load(getClass().getResource("Dungeon.fxml"));
        stage.setScene(new Scene(root));
    }


}
