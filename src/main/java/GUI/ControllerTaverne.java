package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jeu_console.Combattant.Combattant;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import jeu_console.Combattant.Enemy;
import jeu_console.Combattant.Hero.Hero;
import jeu_console.Combattant.Hero.cc_distance.Hunter;
import jeu_console.Combattant.Hero.cc_distance.Warrior;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Healer;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Mage;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.conso.Potion;
import jeu_console.Item.arme_potion.consommable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.Arrays;

import static jeu_console.Combattant.Hero.cc_distance.Hunter.gHunter;
import static jeu_console.Combattant.Hero.cc_distance.Warrior.gWarrior;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Healer.gHealer;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Mage.gMage;


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
    private Text sur1;
    @FXML
    private Text sur2;
    @FXML
    private Text sur3;
    @FXML
    private Text sur4;
    @FXML
    private Text un;
    @FXML
    private Text deux;
    @FXML
    private Text trois;
    @FXML
    private Text quatre;


    @FXML
    void choix1(MouseEvent event) {
        setNombre_héros(1);

        Hero[] temp=new Hero[1];
        setListehéros(temp);

        String[] temp2=new String[1];
        setListeclasse(temp2);

        Weapon[] temp3=new Weapon[1];
        setListe_arme(temp3);

        Enemy[] temp4=new Enemy[1];
        setListe_enemy(temp4);
        for (int i = 0; i < liste_enemy.length; i++) {
            liste_enemy[i]=Enemy.genEnemy(1);
        }

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


        sur1.setVisible(true);
        un.setVisible(true);
    }

    @FXML
    void choix2(MouseEvent event) {
        setNombre_héros(2);

        Hero[] temp=new Hero[2];
        setListehéros(temp);

        String[] temp2=new String[2];
        setListeclasse(temp2);

        Weapon[] temp3=new Weapon[2];
        setListe_arme(temp3);

        Enemy[] temp4=new Enemy[2];
        setListe_enemy(temp4);
        for (int i = 0; i < liste_enemy.length; i++) {
            liste_enemy[i]=Enemy.genEnemy(1);
        }

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


        sur2.setVisible(true);
        un.setVisible(true);
    }

    @FXML
    void choix3(MouseEvent event) {
        setNombre_héros(3);

        Hero[] temp=new Hero[3];
        setListehéros(temp);

        String[] temp2=new String[3];
        setListeclasse(temp2);

        Weapon[] temp3=new Weapon[3];
        setListe_arme(temp3);

        Enemy[] temp4=new Enemy[3];
        setListe_enemy(temp4);
        for (int i = 0; i < liste_enemy.length; i++) {
            liste_enemy[i]=Enemy.genEnemy(1);
        }

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


        sur3.setVisible(true);
        un.setVisible(true);
    }

    @FXML
    void choix4(MouseEvent event) {
        setNombre_héros(4);

        Hero[] temp=new Hero[4];
        setListehéros(temp);

        String[] temp2=new String[4];
        setListeclasse(temp2);

        Weapon[] temp3=new Weapon[4];
        setListe_arme(temp3);

        Enemy[] temp4=new Enemy[4];
        setListe_enemy(temp4);
        for (int i = 0; i < liste_enemy.length; i++) {
            liste_enemy[i]=Enemy.genEnemy(1);
        }

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


        sur4.setVisible(true);
        un.setVisible(true);
    }



    @FXML
    void genHealer(MouseEvent event) {
        if (nombre_héros==1){
            listehéros[0]=gHealer(listehéros,liste_arme,0);
            listeclasse[0]="healer";

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            sur1.setVisible(false);
            un.setVisible(false);
            sortieTav.setVisible(true);
        }

        if (nombre_héros==2){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==1){
                        listehéros[1] = gHealer(listehéros,liste_arme,1);
                        listeclasse[1]="healer";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur2.setVisible(false);
                        deux.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 1) {
                        listehéros[i]= gHealer(listehéros,liste_arme,i);
                        listeclasse[i]="healer";
                        a=false;
                        un.setVisible(false);
                        deux.setVisible(true);
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==3){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==2){
                        listehéros[2] = gHealer(listehéros,liste_arme,2);
                        listeclasse[2]="healer";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur3.setVisible(false);
                        trois.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listehéros[i]= gHealer(listehéros,liste_arme,i);
                        listeclasse[i]="healer";
                        a=false;
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==4){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==3){
                        listehéros[3] = gHealer(listehéros,liste_arme,3);
                        listeclasse[3]="healer";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur4.setVisible(false);
                        quatre.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 3) {
                        listehéros[i]= gHealer(listehéros,liste_arme,i);
                        listeclasse[i]="healer";
                        a=false;
                        if(i==2){
                            trois.setVisible(false);
                            quatre.setVisible(true);
                        }
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }
    }

    @FXML
    void genHunter(MouseEvent event) {
        if (nombre_héros==1){
            listehéros[0] = gHunter(listehéros,liste_arme,0);
            listeclasse[0]="hunter";

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            sur1.setVisible(false);
            un.setVisible(false);
            sortieTav.setVisible(true);
        }

        if (nombre_héros==2){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==1){
                        listehéros[1] = gHunter(listehéros,liste_arme,1);
                        listeclasse[1]="hunter";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur2.setVisible(false);
                        deux.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 1) {
                        listehéros[1] = gHunter(listehéros,liste_arme,i);
                        listeclasse[1]="hunter";
                        a = false;
                        un.setVisible(false);
                        deux.setVisible(true);
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==3){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==2){
                        listehéros[2] = gHunter(listehéros,liste_arme,2);
                        listeclasse[2]="hunter";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur3.setVisible(false);
                        trois.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listehéros[i] = gHunter(listehéros,liste_arme,i);
                        listeclasse[i]="hunter";
                        a = false;
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==4){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==3){
                        listehéros[3] = gHunter(listehéros,liste_arme,3);
                        listeclasse[3]="hunter";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur4.setVisible(false);
                        quatre.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 3) {
                        listehéros[i] = gHunter(listehéros,liste_arme,i);
                        listeclasse[i]="hunter";
                        a = false;
                        if(i==2){
                            trois.setVisible(false);
                            quatre.setVisible(true);
                        }
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }
    }

    @FXML
    void genMage(MouseEvent event) {
        if (nombre_héros==1){
            listehéros[0]=gMage(listehéros,liste_arme,0);
            listeclasse[0]="mage";

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            sur1.setVisible(false);
            un.setVisible(false);
            sortieTav.setVisible(true);
        }

        if (nombre_héros==2){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==1){
                        listehéros[1]=gMage(listehéros,liste_arme,1);
                        listeclasse[1]="mage";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur2.setVisible(false);
                        deux.setVisible(false);
                        sortieTav.setVisible(true);

                    }
                    if (i != 1) {
                        listehéros[i]=gMage(listehéros,liste_arme,i);
                        listeclasse[i]="mage";
                        a = false;
                        un.setVisible(false);
                        deux.setVisible(true);
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==3){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==2){
                        listehéros[2]=gMage(listehéros,liste_arme,2);
                        listeclasse[2]="mage";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur3.setVisible(false);
                        trois.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listehéros[i]=gMage(listehéros,liste_arme,i);
                        listeclasse[i]="mage";
                        a = false;
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==4){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==3){
                        listehéros[3]=gMage(listehéros,liste_arme,3);
                        listeclasse[3]="mage";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur4.setVisible(false);
                        quatre.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 3) {
                        listehéros[i]=gMage(listehéros,liste_arme,i);
                        listeclasse[i]="mage";
                        a = false;
                        if(i==2){
                            trois.setVisible(false);
                            quatre.setVisible(true);
                        }
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }
    }

    @FXML
    void genWarrior(MouseEvent event) {
        if (nombre_héros==1){
            listeclasse[0]="warrior";
            listehéros[0]=gWarrior(listehéros,liste_arme,0);

            énoncé2.setVisible(false);
            GHealer.setVisible(false);
            GWarrior.setVisible(false);
            GMAge.setVisible(false);
            GHunter.setVisible(false);
            sur1.setVisible(false);
            un.setVisible(false);
            sortieTav.setVisible(true);

        }

        if (nombre_héros==2){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==1){
                        listeclasse[1]="warrior";
                        listehéros[1]=gWarrior(listehéros,liste_arme,1);
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur2.setVisible(false);
                        deux.setVisible(false);
                        sortieTav.setVisible(true);

                    }
                    if (i != 1) {
                        listeclasse[i]="warrior";
                        listehéros[i]=gWarrior(listehéros,liste_arme,i);
                        a = false;
                        un.setVisible(false);
                        deux.setVisible(true);
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==3){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==2){
                        listehéros[2]=gWarrior(listehéros,liste_arme,2);
                        listeclasse[2]="warrior";
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur3.setVisible(false);
                        trois.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 2) {
                        listeclasse[i]="warrior";
                        listehéros[i]=gWarrior(listehéros,liste_arme,i);
                        a = false;
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }

        if (nombre_héros==4){
            Boolean a=true;
            int i =0;
            while(a){

                if (listehéros[i]==null){
                    if(i==3){
                        listeclasse[3]="warrior";
                        listehéros[i]=gWarrior(listehéros,liste_arme,3);
                        a = false;
                        énoncé2.setVisible(false);
                        GHealer.setVisible(false);
                        GWarrior.setVisible(false);
                        GMAge.setVisible(false);
                        GHunter.setVisible(false);
                        sur4.setVisible(false);
                        quatre.setVisible(false);
                        sortieTav.setVisible(true);
                    }
                    if (i != 3) {
                        listeclasse[i]="warrior";
                        listehéros[i]=gWarrior(listehéros,liste_arme,i);
                        a = false;
                        if(i==2){
                            trois.setVisible(false);
                            quatre.setVisible(true);
                        }
                        if(i==1){
                            deux.setVisible(false);
                            trois.setVisible(true);
                        }
                        if(i==0){
                            un.setVisible(false);
                            deux.setVisible(true);
                        }
                    }
                }
                i+=1;
            }

        }
    }

    @FXML
    void entDungeon(MouseEvent event) throws IOException {
        Stage stage= (Stage) sortieTav.getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("Dungeon.fxml"));
        stage.setScene(new Scene(root));
        //System.out.println(Arrays.toString(liste_enemy));
        //System.out.println(Arrays.toString(listehéros));
        //System.out.println(Arrays.toString(listeclasse));
    }



}
