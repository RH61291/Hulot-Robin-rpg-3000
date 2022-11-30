package GUI;

import javafx.scene.control.Label;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;


@EqualsAndHashCode
@ToString

@Getter
@Setter

public class Core {

    public static void créaFile() throws FileNotFoundException {
        try {
            File file = new File("paramètre.txt"); //créer un fichier txt
            file.createNewFile();
            FileWriter fw = new FileWriter("paramètre.txt", false);
            fw.write("nombre_héros"); //1er ligne du fichier
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String lecture(int ligne) throws FileNotFoundException {
        int i;
        String line = new String();
        try {
            FileReader file = new FileReader("paramètre.txt");
            BufferedReader buffer = new BufferedReader(file);

            for (i = 1; i < 10; i++) { //lit les 10 premiere ligne
                if (i == ligne)
                    line = buffer.readLine();
                else
                    buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line; //retourne la ligne
    }

    public static void ecriture(String data) {
        try {
            FileWriter fw = new FileWriter("paramètre.txt", true);//écrit dans un fichier txt
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeData(String data, int x, int y, Label label) { //méthode pour changer l"emplacement et le text d'un label
        label.setText(data);
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setVisible(true);
    }

}
