package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import jeu_console.Combattant.Combattant;
import jeu_console.Combattant.Enemy;
import jeu_console.Combattant.Hero.Hero;
import jeu_console.Combattant.Hero.cc_distance.Hunter;
import jeu_console.Combattant.Hero.cc_distance.Warrior;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Healer;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Mage;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.consommable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static java.lang.Math.abs;
import static jeu_console.Combattant.Combattant.receiveDamage;
import static jeu_console.Combattant.Enemy.charge;
import static jeu_console.Combattant.Enemy.genBoss;
import static jeu_console.Combattant.Hero.cc_distance.Hunter.*;
import static jeu_console.Combattant.Hero.cc_distance.Warrior.*;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Healer.*;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Mage.*;


public class ControllerDungeon extends Core {
    private Enemy[] liste_enemy;
    private Hero[] liste_héros;
    private Weapon[] liste_arme;
    private int tourHero = 0;
    private String[] liste_classe = lecture(6).split(" ");
    private String nombre_héros = lecture(2);
    private int potion;
    private int attaque;
    private int cible;
    @FXML
    private Button but1;
    @FXML
    private Button rec;
    @FXML
    private Label textdégatrecu;
    @FXML
    private Text perdu;
    private String repath = "src/main/resources/picture/";
    private int combat = 1;
    @FXML
    private ImageView end;


    @FXML
    private ImageView fl1;
    @FXML
    private ImageView fl2;
    @FXML
    private ImageView fl3;
    @FXML
    private ImageView fl4;
    @FXML
    private ImageView fond;
    @FXML
    private ImageView imhe1; //image héros et ennemis
    @FXML
    private ImageView imhe2;
    @FXML
    private ImageView imhe3;
    @FXML
    private ImageView imhe4;
    private String repath2 = "src/main/resources/picture/dungeon1/";
    private String repath3 = "src/main/resources/picture/dungeon2/";
    private String repath4 = "src/main/resources/picture/dungeon3/";
    private String repath5 = "src/main/resources/picture/dungeon4/";
    private String repath6 = "src/main/resources/picture/finaldungeon/";
    @FXML
    private Label he1;
    @FXML
    private Label he2;
    @FXML
    private Label he3;
    @FXML
    private Label he4;
    @FXML
    private Label en1;  //label héros et ennemis
    @FXML
    private Label en2;
    @FXML
    private Label en3;
    @FXML
    private Label en4;
    @FXML
    private ImageView ien1;
    @FXML
    private ImageView ien2;
    @FXML
    private ImageView ien3;
    @FXML
    private ImageView ien4;
    @FXML
    private MenuButton menu;
    //----------------------------------------------------------------------------
    @FXML
    private MenuItem boeuf;
    @FXML
    private MenuItem repas_fait_maison;
    @FXML
    private MenuItem pasNour;
    //----------------------------------------------------------------------------
    @FXML
    private MenuItem parmure;
    @FXML
    private MenuItem paspot;
    @FXML
    private MenuItem pdégat;
    @FXML
    private MenuItem pmana;
    @FXML
    private MenuItem pvie;
    //----------------------------------------------------------------------------
    @FXML
    private MenuItem atk1;
    @FXML
    private MenuItem atk2;
    @FXML
    private MenuItem atk3;
    @FXML
    private MenuItem atk4;
    @FXML
    private MenuItem atk5;
    @FXML
    private MenuItem atk6;
    @FXML
    private MenuItem atk7;
    @FXML
    private MenuItem atk8;
    @FXML
    private MenuItem atk9;
    @FXML
    private MenuItem atk10;
    @FXML
    private MenuItem atk11;
    @FXML
    private MenuItem pasBalle;
    @FXML
    private MenuItem pasMana;
    @FXML
    private MenuItem Ci10;
    @FXML
    private MenuItem Ci11;
    @FXML
    private MenuItem Ci12;
    @FXML
    private MenuItem Ci13;
    @FXML
    private MenuItem Ci14;
    @FXML
    private MenuItem Ci15;
    @FXML
    private MenuItem Ci16;
    @FXML
    private MenuItem Ci17;
    @FXML
    private MenuItem Ci20;
    @FXML
    private MenuItem Ci21;
    @FXML
    private MenuItem Ci22;
    @FXML
    private MenuItem Ci23;
    @FXML
    private MenuItem Ci24;
    @FXML
    private MenuItem Ci25;
    @FXML
    private MenuItem Ci26;
    @FXML
    private MenuItem Ci27;
    @FXML
    private MenuItem Ci30;
    @FXML
    private MenuItem Ci31;
    @FXML
    private MenuItem Ci32;
    @FXML
    private MenuItem Ci33;
    @FXML
    private MenuItem Ci34;
    @FXML
    private MenuItem Ci35;
    @FXML
    private MenuItem Ci36;
    @FXML
    private MenuItem Ci37;
    @FXML
    private MenuItem Ci40;
    @FXML
    private MenuItem Ci41;
    @FXML
    private MenuItem Ci42;
    @FXML
    private MenuItem Ci43;
    @FXML
    private MenuItem Ci44;
    @FXML
    private MenuItem Ci45;
    @FXML
    private MenuItem Ci46;
    @FXML
    private MenuItem Ci47;
    @FXML
    private MenuItem hero1;
    @FXML
    private MenuItem hero11;
    @FXML
    private MenuItem hero2;
    @FXML
    private MenuItem hero21;
    @FXML
    private MenuItem hero3;
    @FXML
    private MenuItem hero31;
    @FXML
    private MenuItem hero4;
    @FXML
    private MenuItem hero41;
    @FXML
    private MenuItem Actions;
    @FXML
    private Label textdégat;
    //----------------------------------------------------------------------------
    @FXML
    private Button sortir;
    @FXML
    private Button recarme;
    @FXML
    private Button recdef;
    @FXML
    private Button recchance;
    @FXML
    private MenuButton recpotion;
    @FXML
    private Button recnour;
    @FXML
    private Button recmana;
    @FXML
    private Label reclabel;


    public ControllerDungeon() throws FileNotFoundException {
    }

    public void affFleche(int n) throws FileNotFoundException { //pour afficher le curseur sous le héros
        if (n == 0) { //si n, la position du héros
            fl1.setVisible(true); //affiche le curseur correspondant et cache les autres
            fl2.setVisible(false);
            fl3.setVisible(false);
            fl4.setVisible(false);
        } else if (n == 1) {
            fl1.setVisible(false);
            fl2.setVisible(true);
            fl3.setVisible(false);
            fl4.setVisible(false);
        } else if (n == 2) {
            fl1.setVisible(false);
            fl2.setVisible(false);
            fl3.setVisible(true);
            fl4.setVisible(false);
        } else {
            fl1.setVisible(false);
            fl2.setVisible(false);
            fl3.setVisible(false);
            fl4.setVisible(true);
        }
    }

    public void affImage(String classe, int n, boolean en_vie) throws FileNotFoundException { //affiche l'image des héros à la bonne place et varainte si ils sont mort
        if (classe.equals("healer")) { //si healer
            if (n == 0) {// si 1er place
                String path = "";
                if (en_vie == true) {//si en vie
                    path = repath + "Plague_Doctor.png"; //complète le path de l'image
                } else {
                    path = repath + "Plague_Doctorgris.png";
                }
                imhe1.setVisible(true);
                InputStream stream = new FileInputStream(path); //affiche l'image
                Image image = new Image(stream);
                imhe1.setImage(image);
            } else if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Plague_Doctor.png";
                } else {
                    path = repath + "Plague_Doctorgris.png";
                }
                imhe2.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe2.setImage(image);
            } else if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Plague_Doctor.png";
                } else {
                    path = repath + "Plague_Doctorgris.png";
                }
                imhe3.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe3.setImage(image);
            } else {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Plague_Doctor.png";
                } else {
                    path = repath + "Plague_Doctorgris.png";
                }
                imhe4.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe4.setImage(image);
            }
        }
        if (classe.equals("warrior")) {
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "BountyHunter.png";
                } else {
                    path = repath + "BountyHuntergrsi.png";
                }
                imhe1.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe1.setImage(image);
            } else if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "BountyHunter.png";
                } else {
                    path = repath + "BountyHuntergrsi.png";
                }
                imhe2.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe2.setImage(image);
            } else if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "BountyHunter.png";
                } else {
                    path = repath + "BountyHuntergrsi.png";
                }
                imhe3.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe3.setImage(image);
            } else {
                String path = "";
                if (en_vie == true) {
                    path = repath + "BountyHunter.png";
                } else {
                    path = repath + "BountyHuntergrsi.png";
                }
                imhe4.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe4.setImage(image);
            }
        }
        if (classe.equals("hunter")) {
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Hwyman.png";
                } else {
                    path = repath + "Hwymangris.png";
                }
                imhe1.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe1.setImage(image);
            } else if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Hwyman.png";
                } else {
                    path = repath + "Hwymangris.png";
                }
                imhe2.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe2.setImage(image);
            } else if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Hwyman.png";
                } else {
                    path = repath + "Hwymangris.png";
                }
                imhe3.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe3.setImage(image);
            } else {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Hwyman.png";
                } else {
                    path = repath + "Hwymangris.png";
                }
                imhe4.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe4.setImage(image);
            }
        }
        if (classe.equals("mage")) {
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Occultist.png";
                } else {
                    path = repath + "Occultistgris.png";
                }
                imhe1.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe1.setImage(image);
            } else if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Occultist.png";
                } else {
                    path = repath + "Occultistgris.png";
                }
                imhe2.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe2.setImage(image);
            } else if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Occultist.png";
                } else {
                    path = repath + "Occultistgris.png";
                }
                imhe3.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe3.setImage(image);
            } else {
                String path = "";
                if (en_vie == true) {
                    path = repath + "Occultist.png";
                } else {
                    path = repath + "Occultistgris.png";
                }
                imhe4.setVisible(true);
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                imhe4.setImage(image);
            }
        }
    }

    public void affImageEN(int n, boolean en_vie, int combat) throws FileNotFoundException {
        if (combat == 1) { //dépent du combat, affichige l'image du bon monstre au bon endroit
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath2 + "Bone_Arbalist.png";
                } else {
                    path = repath2 + "Bone_Arbalistgris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien1.setImage(image);
            }
            if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath2 + "Bone_Courtier.png";
                } else {
                    path = repath2 + "Bone_Courtiergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien2.setImage(image);
            }
            if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath2 + "Bone_Defender.png";
                } else {
                    path = repath2 + "Bone_Defendergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien3.setImage(image);
            }
            if (n == 3) {
                String path = "";
                if (en_vie == true) {
                    path = repath2 + "Bone_Solider.png";
                } else {
                    path = repath2 + "Bone_Solidergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien4.setImage(image);
            }
        } else if (combat == 2) {
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath3 + "Brigand_Hunter.png";
                } else {
                    path = repath3 + "Brigand_Huntergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien1.setImage(image);
            }
            if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath3 + "Brigand_Raider.png";
                } else {
                    path = repath3 + "Brigand_Raidergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien2.setImage(image);
            }
            if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath3 + "Cutthroat_Defend.png";
                } else {
                    path = repath3 + "Cutthroat_Defendgris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien3.setImage(image);
            }
            if (n == 3) {
                String path = "";
                if (en_vie == true) {
                    path = repath3 + "Vvulf.png";
                } else {
                    path = repath3 + "Vvulfgris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien4.setImage(image);
            }
        } else if (combat == 3) {
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath4 + "Spitter.png";
                } else {
                    path = repath4 + "Spittergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien1.setImage(image);
            }
            if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath4 + "Cultist.png";
                } else {
                    path = repath4 + "Cultistgris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien2.setImage(image);
            }
            if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath4 + "Gargoyle.png";
                } else {
                    path = repath4 + "Gargoylegris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien3.setImage(image);
            }
            if (n == 3) {
                String path = "";
                if (en_vie == true) {
                    path = repath4 + "Ghoul.png";
                } else {
                    path = repath4 + "Ghoulgris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien4.setImage(image);
            }
        } else if (combat == 4) {
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath5 + "Swine_Drummer.png";
                } else {
                    path = repath5 + "Swine_Drummergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien1.setImage(image);
            }
            if (n == 1) {
                String path = "";
                if (en_vie == true) {
                    path = repath5 + "Swine_Slasher.png";
                } else {
                    path = repath5 + "Swine_Slashergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien2.setImage(image);
            }
            if (n == 2) {
                String path = "";
                if (en_vie == true) {
                    path = repath5 + "Swine_Skiver.png";
                } else {
                    path = repath5 + "Swine_Skivergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien3.setImage(image);
            }
            if (n == 3) {
                String path = "";
                if (en_vie == true) {
                    path = repath5 + "Swine_Chopper.png";
                } else {
                    path = repath5 + "Swine_Choppergris.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien4.setImage(image);
            }
        } else if (combat == 5) {
            if (n == 0) {
                String path = "";
                if (en_vie == true) {
                    path = repath6 + "HoD.png";
                } else {
                    path = repath6 + "HoD.png";
                }
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                ien1.setImage(image);
            }
        }
    }

    public void affHero(String classe, int n, boolean vie) throws FileNotFoundException {//affiche le statut et image actualisé du héros à la place n
        if (n == 0) {
            if (classe.equals("healer")) {
                writeData("healer " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getSoin_base() + liste_arme[n].getBonus_soin()) + " soin\n" + liste_héros[n].getCurrent_magie() + " magie", 100, 300, he1);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("mage")) {
                writeData("mage " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + liste_héros[n].getCurrent_magie() + " magie", 100, 300, he1);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("hunter")) {
                writeData("hunter " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + " nombre de balles " + liste_héros[n].getNbfleche() +
                        "\ntype de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 100, 300, he1);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else {
                writeData("warrior " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + " type de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 100, 300, he1);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            }
        } else if (n == 1) {
            if (classe.equals("healer")) {
                writeData("healer " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getSoin_base() + liste_arme[n].getBonus_soin()) + " soin\n" + liste_héros[n].getCurrent_magie() + " magie", 400, 300, he2);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("mage")) {
                writeData("mage " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + liste_héros[n].getCurrent_magie() + " magie", 400, 300, he2);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("hunter")) {
                writeData("hunter " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + " nombre de balles " + liste_héros[n].getNbfleche() +
                        "\ntype de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 400, 300, he2);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else {
                writeData("warrior " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + " type de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 400, 300, he2);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            }
        } else if (n == 2) {
            if (classe.equals("healer")) {
                writeData("healer " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getSoin_base() + liste_arme[n].getBonus_soin()) + " soin\n" + liste_héros[n].getCurrent_magie() + " magie", 700, 300, he3);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("mage")) {
                writeData("mage " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + liste_héros[n].getCurrent_magie() + " magie", 700, 300, he3);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("hunter")) {
                writeData("hunter " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + "nombre de balles " + liste_héros[n].getNbfleche() +
                        "\ntype de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 700, 300, he3);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else {
                writeData("warrior " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + " type de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 700, 300, he3);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            }
        } else {
            if (classe.equals("healer")) {
                writeData("healer " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getSoin_base() + liste_arme[n].getBonus_soin()) + " soin\n" + liste_héros[n].getCurrent_magie() + " magie", 1000, 300, he4);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("mage")) {
                writeData("mage " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + liste_héros[n].getCurrent_magie() + " magie", 1000, 300, he4);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else if (classe.equals("hunter")) {
                writeData("hunter " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + " nombre de balles " + liste_héros[n].getNbfleche() +
                        "\ntype de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 1000, 300, he4);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            } else {
                writeData("warrior " + "\n" + liste_héros[n].getCurrent_health() + "pv\n" + liste_héros[n].getCurrent_def() + " def\n" + (liste_héros[n].getDegat_base() + liste_arme[n].getBonus_degat()) + " dégat non élémentaire\n" + " type de dégat " + liste_arme[n].getType() + " avec " + liste_arme[n].getType_degat() + " dégat élémentaire", 1000, 300, he4);
                if (vie == true) {
                    affImage(classe, n, true);
                } else {
                    affImage(classe, n, false);
                }
            }
        }

    }

    @FXML
    public void aff(MouseEvent event) throws FileNotFoundException {
        if (combat == 1) {
            String nombre_héros = lecture(2);
            if (nombre_héros.equals("1")) {
                en1.setVisible(true); //affiche les ennemi, héros et label correspondant au nombre d'ennemi
                he1.setVisible(true);
                ien1.setVisible(true);

                liste_enemy = new Enemy[1]; //initialise les liste
                liste_héros = new Hero[1];
                liste_arme = new Weapon[1];

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat); //génère les ennemis avec niveau correspondant

                    if (liste_classe[i].equals("healer")) {
                        liste_héros[i] = gHealer(liste_héros, liste_arme, i);
                        affHero("healer", i, true);
                    } else if (liste_classe[i].equals("mage")) {
                        liste_héros[i] = gMage(liste_héros, liste_arme, i);
                        affHero("mage", i, true);
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i] = gHunter(liste_héros, liste_arme, i);
                        affHero("hunter", i, true);
                    } else {
                        liste_héros[i] = gWarrior(liste_héros, liste_arme, i);
                        affHero("warrior", i, true);
                    }
                }

                writeData("Bone Arbalist " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                affImageEN(0, true, combat);
            }

            if (nombre_héros.equals("2")) {
                en1.setVisible(true);
                en2.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);

                liste_enemy = new Enemy[2];
                liste_héros = new Hero[2];
                liste_arme = new Weapon[2];

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        liste_héros[i] = gHealer(liste_héros, liste_arme, i);
                        affHero("healer", i, true);
                    } else if (liste_classe[i].equals("mage")) {
                        liste_héros[i] = gMage(liste_héros, liste_arme, i);
                        affHero("mage", i, true);
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i] = gHunter(liste_héros, liste_arme, i);
                        affHero("hunter", i, true);
                    } else {
                        liste_héros[i] = gWarrior(liste_héros, liste_arme, i);
                        affHero("warrior", i, true);
                    }

                }

                writeData("Bone Arbalist" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Bone Courtier" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
            }

            if (nombre_héros.equals("3")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);

                liste_enemy = new Enemy[3];
                liste_héros = new Hero[3];
                liste_arme = new Weapon[3];

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        liste_héros[i] = gHealer(liste_héros, liste_arme, i);
                        affHero("healer", i, true);
                    } else if (liste_classe[i].equals("mage")) {
                        liste_héros[i] = gMage(liste_héros, liste_arme, i);
                        affHero("mage", i, true);
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i] = gHunter(liste_héros, liste_arme, i);
                        affHero("hunter", i, true);
                    } else {
                        liste_héros[i] = gWarrior(liste_héros, liste_arme, i);
                        affHero("warrior", i, true);
                    }
                }
                writeData("Bone Arbalist" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Bone Courtier" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Bone Defender" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
            }

            if (nombre_héros.equals("4")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                en4.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                he4.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);
                ien4.setVisible(true);


                liste_enemy = new Enemy[4];
                liste_héros = new Hero[4];
                liste_arme = new Weapon[4];

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        liste_héros[i] = gHealer(liste_héros, liste_arme, i);
                        affHero("healer", i, true);
                    } else if (liste_classe[i].equals("mage")) {
                        liste_héros[i] = gMage(liste_héros, liste_arme, i);
                        affHero("mage", i, true);
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i] = gHunter(liste_héros, liste_arme, i);
                        affHero("hunter", i, true);
                    } else {
                        liste_héros[i] = gWarrior(liste_héros, liste_arme, i);
                        affHero("warrior", i, true);
                    }
                }
                writeData("Bone Arbalist" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Bone Courtier" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Bone Defender" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                writeData("Bone Soldier" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
                affImageEN(3, true, combat);
            }
            but1.setVisible(false);
            menu.setVisible(true);

            affFleche(tourHero);
        }
        if (combat == 2) {
            for (int i = 0; i < liste_héros.length; i++) {
                if (liste_héros[i].getCurrent_health() > 0) {
                    tourHero = i;
                    break;
                }
            }

            if (nombre_héros.equals("1")) {
                en1.setVisible(true);
                he1.setVisible(true);
                ien1.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);

                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }

                writeData("Brigand Hunter " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                affImageEN(0, true, combat);
            }

            if (nombre_héros.equals("2")) {
                en1.setVisible(true);
                en2.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }

                }

                writeData("Brigand Hunter" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Brigand Raider" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
            }

            if (nombre_héros.equals("3")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
                writeData("Brigand Hunter" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Brigand Raider" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Cutthroat" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
            }

            if (nombre_héros.equals("4")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                en4.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                he4.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);
                ien4.setVisible(true);


                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                                liste_héros[i].setMagie(liste_héros[i].getMagie());
                            } else {
                                liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                            }
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
                writeData("Brigand Hunter" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Brigand Raider" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Cutthroat" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                writeData("Vvulf" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
                affImageEN(3, true, combat);
            }
            but1.setVisible(false);
            menu.setVisible(true);

            affFleche(tourHero);
        }
        if (combat == 3) {
            for (int i = 0; i < liste_héros.length; i++) {
                if (liste_héros[i].getCurrent_health() > 0) {
                    tourHero = i;
                    break;
                }
            }

            if (nombre_héros.equals("1")) {
                en1.setVisible(true);
                he1.setVisible(true);
                ien1.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);

                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }

                writeData("Spitter " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                affImageEN(0, true, combat);
            }

            if (nombre_héros.equals("2")) {
                en1.setVisible(true);
                en2.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }

                }

                writeData("Spitter" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Cultist" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
            }

            if (nombre_héros.equals("3")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
                writeData("Spitter" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Cultist" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Gargoyle" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
            }

            if (nombre_héros.equals("4")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                en4.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                he4.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);
                ien4.setVisible(true);


                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                                liste_héros[i].setMagie(liste_héros[i].getMagie());
                            } else {
                                liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                            }
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
                writeData("Spitter" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Cultist" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Gargoyle" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                writeData("Ghoul" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
                affImageEN(3, true, combat);
            }
            but1.setVisible(false);
            menu.setVisible(true);

            affFleche(tourHero);
        }
        if (combat == 4) {
            for (int i = 0; i < liste_héros.length; i++) {
                if (liste_héros[i].getCurrent_health() > 0) {
                    tourHero = i;
                    break;
                }
            }

            if (nombre_héros.equals("1")) {
                en1.setVisible(true);
                he1.setVisible(true);
                ien1.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);

                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }

                writeData("Swine Drummer " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                affImageEN(0, true, combat);
            }

            if (nombre_héros.equals("2")) {
                en1.setVisible(true);
                en2.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }

                }

                writeData("Swine Drummer" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Swine Slasher" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
            }

            if (nombre_héros.equals("3")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);

                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
                writeData("Swine Drummer" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Swine Slasher" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Swine Skiver" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
            }

            if (nombre_héros.equals("4")) {
                en1.setVisible(true);
                en2.setVisible(true);
                en3.setVisible(true);
                en4.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                he4.setVisible(true);
                ien1.setVisible(true);
                ien2.setVisible(true);
                ien3.setVisible(true);
                ien4.setVisible(true);


                for (int i = 0; i < liste_enemy.length; i++) {
                    liste_enemy[i] = Enemy.genEnemy(combat);
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                                liste_héros[i].setMagie(liste_héros[i].getMagie());
                            } else {
                                liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                            }
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
                writeData("Swine Drummer" + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
                writeData("Swine Slasher" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
                writeData("Swine Skiver" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
                writeData("Swine Chopper" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
                affImageEN(0, true, combat);
                affImageEN(1, true, combat);
                affImageEN(2, true, combat);
                affImageEN(3, true, combat);
            }
            but1.setVisible(false);
            menu.setVisible(true);

            affFleche(tourHero);
        }
        if (combat == 5) {
            liste_enemy = new Enemy[1];
            liste_enemy[0] = genBoss();
            writeData("Heart of the dungeon " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
            affImageEN(0, true, combat);

            ien2.setVisible(false);
            ien3.setVisible(false);
            ien4.setVisible(false);
            en2.setVisible(false); //désactive autre image
            en3.setVisible(false);
            en4.setVisible(false);

            Ci10.setText("Hearth of the dungeon "); //set le text des meu item sur le nom du monstre
            Ci11.setText("Hearth of the dungeon");
            Ci12.setText("Hearth of the dungeon ");
            Ci13.setText("Hearth of the dungeon ");
            Ci14.setText("Hearth of the dungeon");
            Ci15.setText("Hearth of the dungeon");
            Ci16.setText("Hearth of the dungeon");
            Ci17.setText("Hearth of the dungeon ");

            Ci10.setVisible(true);
            Ci11.setVisible(true);
            Ci12.setVisible(true);
            Ci13.setVisible(true);
            Ci14.setVisible(true);
            Ci15.setVisible(true);
            Ci16.setVisible(true);
            Ci17.setVisible(true);

            for (int i = 0; i < liste_héros.length; i++) {
                if (liste_héros[i].getCurrent_health() > 0) {
                    tourHero = i;
                    break;
                }
            }

            if (nombre_héros.equals("1")) {
                en1.setVisible(true);
                he1.setVisible(true);
                ien1.setVisible(true);

                for (int i = 0; i < liste_héros.length; i++) {

                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
            }

            if (nombre_héros.equals("2")) {
                en1.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                ien1.setVisible(true);

                for (int i = 0; i < liste_héros.length; i++) {
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }

                }

            }

            if (nombre_héros.equals("3")) {
                en1.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                ien1.setVisible(true);

                for (int i = 0; i < liste_héros.length; i++) {
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }
            }

            if (nombre_héros.equals("4")) {
                en1.setVisible(true);
                he1.setVisible(true);
                he2.setVisible(true);
                he3.setVisible(true);
                he4.setVisible(true);
                ien1.setVisible(true);

                for (int i = 0; i < liste_héros.length; i++) {
                    if (liste_classe[i].equals("healer")) {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                                liste_héros[i].setMagie(liste_héros[i].getMagie());
                            } else {
                                liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                            }
                            affHero("healer", i, true);
                        } else {
                            affHero("healer", i, false);
                        }
                    } else if (liste_classe[i].equals("mage")) {
                        if (liste_héros[i].getCurrent_magie() < liste_héros[i].getMagie()) {
                            liste_héros[i].setMagie(liste_héros[i].getMagie());
                        } else {
                            liste_héros[i].setMagie(liste_héros[i].getCurrent_magie() + liste_héros[i].getMagie() / 2);
                        }
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("mage", i, true);
                        } else {
                            affHero("mage", i, false);
                        }
                    } else if (liste_classe[i].equals("hunter")) {
                        liste_héros[i].setNbfleche(liste_héros[i].getNbfleche() + 5);
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("hunter", i, true);
                        } else {
                            affHero("hunter", i, false);
                        }
                    } else {
                        if (liste_héros[i].getCurrent_health() > 0) {
                            affHero("warrior", i, true);
                        } else {
                            affHero("warrior", i, false);
                        }
                    }
                }

            }
            but1.setVisible(false);
            menu.setVisible(true);

            affFleche(tourHero);
        }

    }

    @FXML
    void menuManger(MouseEvent event) {
        consommable[] inv = liste_héros[tourHero].getInventaire_consumable(); //inv héros
        boeuf.setVisible(false);
        repas_fait_maison.setVisible(false); //désactive menu item
        int a = 0;
        for (int i = 0; i < inv.length; i++) {
            if (inv[i].getName() != null && inv[i].getName().equals("boeuf")) {
                boeuf.setVisible(true); //réactive si on les trouves
                a += 1;
            } else if (inv[i].getName() != null && inv[i].getName().equals("repas fait maison")) {
                repas_fait_maison.setVisible(true);
                a += 1;
            }
        }
        if (a == 0) { //si inv sans nourriture
            pasNour.setVisible(true); //affiche menu item pas de nourriture
        }
    }

    @FXML
    void manger2(ActionEvent event) throws FileNotFoundException, InterruptedException {
        Hero hero = liste_héros[tourHero];
        consommable[] inv = hero.getInventaire_consumable();
        int i = 0;
        while (true) {
            if (inv[i].getName() != null && inv[i].getName().equals("boeuf")) { //si boeuf
                int soin = inv[i].getSoin();
                double pvact = hero.getCurrent_health();
                double pv = hero.getHealth();
                if (pvact + soin > pv) { //soigne le héros au plus jusqua ses pv max
                    hero.setCurrent_health(pv);
                } else {
                    hero.setCurrent_health(pvact + soin);
                }
                affHero(liste_classe[tourHero], tourHero, true);
                hero.suppConsumable(inv[i]);
                break;
            }
            i += 1;

        }
        if (tourHero != Integer.parseInt(nombre_héros) - 1) { //si le héros n'est pas le dernier de sa ligne
            int temp = tourHero;
            for (int j = tourHero + 1; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j; //cherche le prochain héros vivant et change le tour héros pourquil joue
                    break;
                }
            }
            if (tourHero == temp) { //si pas d'autre héros peuvent jouer
                tourEnemi(liste_enemy, liste_héros);
            }
        } else { //si dernier de sa ligne
            tourEnemi(liste_enemy, liste_héros);
            for (int j = 0; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j; //cherche prochain héros en vie
                    break;
                }
            }
        }
        affFleche(tourHero);
    }   //manger

    @FXML
    void manger3(ActionEvent event) throws FileNotFoundException, InterruptedException {
        Hero hero = liste_héros[tourHero];
        affHero(liste_classe[tourHero], tourHero, true);
        consommable[] inv = hero.getInventaire_consumable();
        int i = 0;
        while (true) {
            if (inv[i].getName() != null && inv[i].getName().equals("repas fait maison")) {
                int soin = inv[i].getSoin();
                double pvact = hero.getCurrent_health();
                double pv = hero.getHealth();
                if (pvact + soin > pv) {
                    hero.setCurrent_health(pv);
                } else {
                    hero.setCurrent_health(pvact + soin);
                }
                affHero(liste_classe[tourHero], tourHero, true);
                hero.suppConsumable(inv[i]);
                break;
            }
            i += 1;

        }
        if (tourHero != Integer.parseInt(nombre_héros) - 1) {
            int temp = tourHero;
            for (int j = tourHero + 1; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
            if (tourHero == temp) {
                tourEnemi(liste_enemy, liste_héros);
            }
        } else {
            tourEnemi(liste_enemy, liste_héros);
            for (int j = 0; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
        }
        affFleche(tourHero);
    }

    //----------------------------------------------------------------------------
    @FXML
    void passer(ActionEvent event) throws FileNotFoundException, InterruptedException { //passer son tour
        if (tourHero != Integer.parseInt(nombre_héros) - 1) {
            int temp = tourHero;
            for (int j = tourHero + 1; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    System.out.println(tourHero);
                    break;
                }
            }
            if (tourHero == temp) {
                tourEnemi(liste_enemy, liste_héros);
            }
        } else {
            tourEnemi(liste_enemy, liste_héros);
            for (int j = 0; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    System.out.println(tourHero);
                    break;
                }
            }
        }
        affFleche(tourHero);
        atk1.setVisible(false); //désactive tout menu item pour pas avoir de menu item fantome
        atk2.setVisible(false);
        atk3.setVisible(false);
        atk4.setVisible(false);
        atk5.setVisible(false);
        atk6.setVisible(false);
        atk7.setVisible(false);
        atk8.setVisible(false);
        atk9.setVisible(false);
        atk10.setVisible(false);
        atk11.setVisible(false);
        boeuf.setVisible(false);
        repas_fait_maison.setVisible(false);
        parmure.setVisible(false);
        pdégat.setVisible(false);
        pvie.setVisible(false);
        pmana.setVisible(false);
        paspot.setVisible(false);
        pasNour.setVisible(false);
        pasBalle.setVisible(false);
        pasMana.setVisible(false);
    }

    @FXML
    void menuBoire(MouseEvent event) {
        consommable[] inv = liste_héros[tourHero].getInventaire_consumable();

        int a = 0;
        for (int i = 0; i < inv.length; i++) { //active les menu item selon disponibilité
            if (inv[i].getName() != null && inv[i].getName().equals("potion de vie")) {
                pvie.setVisible(true);
                a += 1;
            } else if (inv[i].getName() != null && inv[i].getName().equals("potion de mana")) {
                pmana.setVisible(true);
                a += 1;
            } else if (inv[i].getName() != null && inv[i].getName().equals("potion de dégat")) {
                pdégat.setVisible(true);
                a += 1;
            } else if (inv[i].getName() != null && inv[i].getName().equals("potion d'armure")) {
                parmure.setVisible(true);
                a += 1;
            }
        }
        if (a == 0) {
            paspot.setVisible(true);
        }
    }

    @FXML
    void boirearmure(ActionEvent event) throws FileNotFoundException, InterruptedException {
        potion = 1; //atribu valeur au choix effectué
        boire(potion);

    } //potion

    @FXML
    void boiredégat(ActionEvent event) throws FileNotFoundException, InterruptedException {
        potion = 2;
        boire(potion);

    }

    @FXML
    void boiremana(ActionEvent event) throws FileNotFoundException, InterruptedException {
        potion = 3;
        boire(potion);

    }

    @FXML
    void boirepv(ActionEvent event) throws FileNotFoundException, InterruptedException {
        potion = 4;
        boire(potion);

    }

    public void boire(int n) throws FileNotFoundException, InterruptedException {
        Hero hero = liste_héros[tourHero];
        consommable[] inv = hero.getInventaire_consumable();
        int i = 0;
        while (true) { //agissemnt potion
            if (n == 4 && inv[i].getName() != null && inv[i].getName().equals("potion de vie")) {
                int soin = inv[i].getSoin();
                double pvact = hero.getCurrent_health();
                double pv = hero.getHealth();
                if (pvact + soin > pv) {
                    hero.setCurrent_health(pv);
                } else {
                    hero.setCurrent_health(pvact + soin);
                }
                affHero(liste_classe[tourHero], tourHero, true);
                hero.suppConsumable(inv[i]);
                break;
            } else if (n == 3 && inv[i].getName() != null && inv[i].getName().equals("potion de mana")) {
                int Smana = inv[i].getMana();
                double manaact = hero.getCurrent_magie();
                double mana = hero.getMagie();
                if (manaact + Smana > mana) {
                    hero.setCurrent_magie((int) mana);
                } else {
                    hero.setCurrent_health(manaact + Smana);
                }
                affHero(liste_classe[tourHero], tourHero, true);
                hero.suppConsumable(inv[i]);
                break;
            } else if (n == 2 && inv[i].getName() != null && inv[i].getName().equals("potion de dégat")) {
                int bonus_degat = inv[i].getBonus_degat();
                double degat_base = hero.getDegat_base();
                hero.setDegat_base((int) (bonus_degat + degat_base));
                affHero(liste_classe[tourHero], tourHero, true);
                hero.suppConsumable(inv[i]);
                break;
            } else if (n == 1 && inv[i].getName() != null && inv[i].getName().equals("potion d'armure")) {
                int bonus_def = inv[i].getBonus_def();
                double def = hero.getCurrent_def();
                hero.setCurrent_def((int) (def + bonus_def));
                affHero(liste_classe[tourHero], tourHero, true);
                hero.suppConsumable(inv[i]);
                break;
            }
            i += 1;

        }
        if (tourHero != Integer.parseInt(nombre_héros) - 1) {
            int temp = tourHero;
            for (int j = tourHero + 1; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
            if (tourHero == temp) {
                tourEnemi(liste_enemy, liste_héros);
            }
        } else {
            tourEnemi(liste_enemy, liste_héros);
            for (int j = 0; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
        }
        affFleche(tourHero);
        pmana.setVisible(false);
        pvie.setVisible(false);
        parmure.setVisible(false);
        pdégat.setVisible(false);
        paspot.setVisible(false);
    }

    @FXML
    void selectionAtk(MouseEvent event) {
        int[] tabEn = new int[liste_enemy.length];
        for (int i = 0; i < liste_enemy.length; i++) {
            if (liste_enemy[i].getCurrent_health() > 0) {
                tabEn[i] = i; //si en vie
            } else {
                tabEn[i] = -1;//si mort
            }
        }
        for (int i = 0; i < liste_enemy.length; i++) {
            if (tabEn[i] == 0) { //si en vie en 1er position
                Ci10.setVisible(true); //affichage menu item des cible pour toute les attaques selon leurs nombre
                Ci11.setVisible(true);
                Ci12.setVisible(true);
                Ci13.setVisible(true);
                Ci14.setVisible(true);
                Ci15.setVisible(true);
                Ci16.setVisible(true);
                Ci17.setVisible(true);
            } else if (tabEn[i] == 1) {
                Ci20.setVisible(true);
                Ci21.setVisible(true);
                Ci22.setVisible(true);
                Ci23.setVisible(true);
                Ci24.setVisible(true);
                Ci25.setVisible(true);
                Ci26.setVisible(true);
                Ci27.setVisible(true);
            } else if (tabEn[i] == 2) {
                Ci30.setVisible(true);
                Ci31.setVisible(true);
                Ci32.setVisible(true);
                Ci33.setVisible(true);
                Ci34.setVisible(true);
                Ci35.setVisible(true);
                Ci36.setVisible(true);
                Ci37.setVisible(true);
            } else if (tabEn[i] == 3) {
                Ci40.setVisible(true);
                Ci41.setVisible(true);
                Ci42.setVisible(true);
                Ci43.setVisible(true);
                Ci44.setVisible(true);
                Ci45.setVisible(true);
                Ci46.setVisible(true);
                Ci47.setVisible(true);
            }
        }

        int[] tabHe = new int[Integer.parseInt(nombre_héros)];
        int[] tabHeDed = new int[Integer.parseInt(nombre_héros)];
        for (int i = 0; i < tabHe.length; i++) {
            if (liste_héros[i].getCurrent_health() > 0) {
                tabHe[i] = i;//si en vie
            } else {
                tabHe[i] = -1;
            }
            if (liste_héros[i].getCurrent_health() <= 0) {
                tabHeDed[i] = i; //si mort
            } else {
                tabHeDed[i] = -1;
            }
        }
        for (int i = 0; i < tabHe.length; i++) {
            if (tabHe[i] == 0) {
                hero1.setVisible(true); //affichage menu item pour soin que des héros vivant
            }
            if (tabHe[i] == 1) {
                hero2.setVisible(true);
            }
            if (tabHe[i] == 2) {
                hero3.setVisible(true);
            }
            if (tabHe[i] == 3) {
                hero4.setVisible(true);
            }
            if (tabHeDed[i] == 0) {
                hero11.setVisible(true);//affichage menu item pour soin que des héros mort
            }
            if (tabHeDed[i] == 1) {
                hero21.setVisible(true);
            }
            if (tabHeDed[i] == 2) {
                hero31.setVisible(true);
            }
            if (tabHeDed[i] == 3) {
                hero41.setVisible(true);
            }
        }

        if (liste_classe[tourHero].equals("warrior")) { //affichage des menu item des attaque selon les classes
            atk1.setVisible(true);
            atk2.setVisible(true);
        }
        if (liste_classe[tourHero].equals("hunter")) {
            atk3.setVisible(true);
            if (liste_héros[tourHero].getNbfleche() > 0) {
                atk4.setVisible(true);
            } else {
                pasBalle.setVisible(true);
            }
        }
        if (liste_classe[tourHero].equals("mage")) {
            if (liste_héros[tourHero].getCurrent_magie() >= 2) {
                atk5.setVisible(true);
                atk6.setVisible(true);
                atk7.setVisible(true);
                atk8.setVisible(true);
            } else {
                pasMana.setVisible(true);
            }
        }
        if (liste_classe[tourHero].equals("healer")) {
            if (liste_héros[tourHero].getCurrent_magie() >= 2) {
                atk9.setVisible(true);
            }
            if (liste_héros[tourHero].getCurrent_magie() >= 4) {
                atk10.setVisible(true);
            }
            if (liste_héros[tourHero].getCurrent_magie() >= 3) {
                atk11.setVisible(true);
            } else {
                pasMana.setVisible(true);
            }
        }
    }

    @FXML
    void atk1(MouseEvent event) {
        attaque = 1;
    }

    @FXML
    void atk2(MouseEvent event) {
        attaque = 2;
    }

    @FXML
    void atk3(MouseEvent event) {
        attaque = 3;
    }

    @FXML
    void atk4(MouseEvent event) {
        attaque = 4;
    }

    @FXML
    void atk5(MouseEvent event) {
        attaque = 5;
    }

    @FXML
    void atk6(MouseEvent event) {
        attaque = 6;
    }

    @FXML
    void atk7(MouseEvent event) {
        attaque = 7;
    }

    @FXML
    void atk8(MouseEvent event) {
        attaque = 8;
    }

    @FXML
    void atk9(MouseEvent event) {
        attaque = 9;
    }

    @FXML
    void atk10(MouseEvent event) {
        attaque = 10;
    }

    @FXML
    void cible1(ActionEvent event) throws FileNotFoundException, InterruptedException {
        cible = 0;
        attaque(attaque, cible);
    }

    @FXML
    void cible2(ActionEvent event) throws FileNotFoundException, InterruptedException {
        cible = 1;
        attaque(attaque, cible);
    }

    @FXML
    void cible3(ActionEvent event) throws FileNotFoundException, InterruptedException {
        cible = 2;
        attaque(attaque, cible);
    }

    @FXML
    void cible4(ActionEvent event) throws FileNotFoundException, InterruptedException {
        cible = 3;
        attaque(attaque, cible);
    }

    @FXML
    void soinGr(ActionEvent event) throws FileNotFoundException, InterruptedException {
        healGR((Healer) liste_héros[tourHero], liste_héros);
        for (int i = 0; i < liste_héros.length; i++) {
            if (liste_héros[i].getCurrent_health() > liste_héros[i].getHealth()) {
                liste_enemy[i].setCurrent_health(liste_héros[i].getHealth());
            }
            affHero(liste_classe[i], i, true);
        }
        writeData("soin de groupe de " + ((liste_héros[tourHero].getSoin_base() + liste_arme[tourHero].getBonus_soin()) / 2) + "pv\nsi critique alors x2", 1200, 300, textdégat);
        atk1.setVisible(false);
        atk2.setVisible(false);
        atk3.setVisible(false);
        atk4.setVisible(false);
        atk5.setVisible(false);
        atk6.setVisible(false);
        atk7.setVisible(false);
        atk8.setVisible(false);
        atk9.setVisible(false);
        atk10.setVisible(false);
        atk11.setVisible(false);
        pasBalle.setVisible(false);
        pasMana.setVisible(false);


        if (tourHero != Integer.parseInt(nombre_héros) - 1) {
            int temp = tourHero;
            for (int j = tourHero + 1; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
            if (tourHero == temp) {
                tourEnemi(liste_enemy, liste_héros);
            }
        } else {
            tourEnemi(liste_enemy, liste_héros);
            for (int j = 0; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
        }
        affFleche(tourHero);

    }

    public void attaque(int n, int cible) throws FileNotFoundException, InterruptedException {
        if (n == 1) { //si attaque 1
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(Attaque((Warrior) liste_héros[tourHero]), liste_enemy[cible]); //cible recoit attaque
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 2) {
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(Berserk((Warrior) liste_héros[tourHero]), liste_enemy[cible]);
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 3) {
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(Attaque_au_couteau((Hunter) liste_héros[tourHero]), liste_enemy[cible]);
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 4) {
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(Tir((Hunter) liste_héros[tourHero]), liste_enemy[cible]);
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 5) {
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(bouleDeFeu((Mage) liste_héros[tourHero]), liste_enemy[cible]);
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 6) {
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(lameDeau((Mage) liste_héros[tourHero]), liste_enemy[cible]);
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 7) {
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(séisme((Mage) liste_héros[tourHero]), liste_enemy[cible]);
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 8) {
            double vie = liste_enemy[cible].getCurrent_health();
            receiveDamage(feuilleLame((Mage) liste_héros[tourHero]), liste_enemy[cible]);
            if (liste_enemy[cible].getCurrent_health() < 0) {
                liste_enemy[cible].setCurrent_health(0);
                affImageEN(cible, false, combat);
            }
            double diff = vie - abs(liste_enemy[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat infligé", 1200, 300, textdégat);
        }
        if (n == 9) {
            double vie = liste_héros[cible].getCurrent_health();
            heal((Healer) liste_héros[tourHero], (Combattant) liste_héros[cible]);
            if (liste_héros[cible].getCurrent_health() > liste_héros[cible].getHealth()) {
                liste_enemy[cible].setCurrent_health(liste_héros[cible].getHealth());
            }
            affHero(liste_classe[cible], cible, true);
            double diff = abs(liste_héros[cible].getCurrent_health()) - vie;
            writeData(String.valueOf(diff) + " dégat soigné", 1200, 300, textdégat);
        }
        if (n == 10) {
            ressurect((Healer) liste_héros[tourHero], (Combattant) liste_héros[cible]);
            if (liste_héros[cible].getCurrent_health() > liste_héros[cible].getHealth()) {
                liste_enemy[cible].setCurrent_health(liste_héros[cible].getHealth());
            }
            affHero(liste_classe[cible], cible, true);
            double diff = (liste_héros[cible].getCurrent_health());
            writeData(String.valueOf(diff) + " dégat soigné", 1200, 300, textdégat);
        }

        if (cible == 0) {
            if (combat == 1) {
                writeData("Bone Arbalist " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
            }
            if (combat == 2) {
                writeData("Brigand Hunter " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
            }
            if (combat == 3) {
                writeData("Spitter " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
            }
            if (combat == 4) {
                writeData("Swine Drummer " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
            }
            if (combat == 5) {
                writeData("Heart of the dungeon " + "\n" + liste_enemy[0].getCurrent_health() + "pv\n" + liste_enemy[0].getCurrent_def() + " def\nde type " + liste_enemy[0].getType(), 100, 50, en1);
            }
            Ci10.setVisible(false);
            Ci11.setVisible(false);
            Ci12.setVisible(false);
            Ci13.setVisible(false);
            Ci14.setVisible(false);
            Ci15.setVisible(false);
            Ci16.setVisible(false);
            Ci17.setVisible(false);
            hero1.setVisible(false);
            hero11.setVisible(false);

        }  //affiche le statut actuel des monstres
        else if (cible == 1) {
            if (combat == 1) {
                writeData("Bone Courtier" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
            }
            if (combat == 2) {
                writeData("Brigand Raider" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
            }
            if (combat == 3) {
                writeData("Cultist" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
            }
            if (combat == 4) {
                writeData("Swine Slasher" + "\n" + liste_enemy[1].getCurrent_health() + "pv\n" + liste_enemy[1].getCurrent_def() + " def\nde type " + liste_enemy[1].getType(), 400, 50, en2);
            }
            Ci20.setVisible(false);
            Ci21.setVisible(false);
            Ci22.setVisible(false);
            Ci23.setVisible(false);
            Ci24.setVisible(false);
            Ci25.setVisible(false);
            Ci26.setVisible(false);
            Ci27.setVisible(false);
            hero2.setVisible(false);
            hero21.setVisible(false);
        }
        else if (cible == 2) {
            if (combat == 1) {
                writeData("Bone Defender" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
            }
            if (combat == 2) {
                writeData("Cutthroat" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
            }
            if (combat == 3) {
                writeData("Gargoyle" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
            }
            if (combat == 4) {
                writeData("Swine Skiver" + "\n" + liste_enemy[2].getCurrent_health() + "pv\n" + liste_enemy[2].getCurrent_def() + " def\nde type " + liste_enemy[2].getType(), 700, 50, en3);
            }
            Ci30.setVisible(false);
            Ci31.setVisible(false);
            Ci32.setVisible(false);
            Ci33.setVisible(false);
            Ci34.setVisible(false);
            Ci35.setVisible(false);
            Ci36.setVisible(false);
            Ci37.setVisible(false);
            hero3.setVisible(false);
            hero31.setVisible(false);
        }
        else if (cible == 3) {
            if (combat == 1) {
                writeData("Bone Soldier" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
            }
            if (combat == 2) {
                writeData("Vvulf" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
            }
            if (combat == 3) {
                writeData("Ghoul" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
            }
            if (combat == 4) {
                writeData("Swine Chopper" + "\n" + liste_enemy[3].getCurrent_health() + "pv\n" + liste_enemy[3].getCurrent_def() + " def\nde type " + liste_enemy[3].getType(), 1000, 50, en4);
            }
            Ci40.setVisible(false);
            Ci41.setVisible(false);
            Ci42.setVisible(false);
            Ci43.setVisible(false);
            Ci44.setVisible(false);
            Ci45.setVisible(false);
            Ci46.setVisible(false);
            Ci47.setVisible(false);
            hero4.setVisible(false);
            hero41.setVisible(false);
        }

        atk1.setVisible(false);
        atk2.setVisible(false);
        atk3.setVisible(false);
        atk4.setVisible(false);
        atk5.setVisible(false);
        atk6.setVisible(false);
        atk7.setVisible(false);
        atk8.setVisible(false);
        atk9.setVisible(false);
        atk10.setVisible(false);
        atk11.setVisible(false);
        pasBalle.setVisible(false);
        pasMana.setVisible(false);


        if (tourHero != Integer.parseInt(nombre_héros) - 1) {
            int temp = tourHero;
            for (int j = tourHero + 1; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
            if (tourHero == temp) {
                tourEnemi(liste_enemy, liste_héros);
            }
        } else {
            tourEnemi(liste_enemy, liste_héros);
            for (int j = 0; j < liste_héros.length; j++) {
                if (liste_héros[j].getCurrent_health() > 0) {
                    tourHero = j;
                    break;
                }
            }
        }
        affFleche(tourHero);
        int fin = 0; //initialise le compteur de fin


        for (int i = 0; i < liste_enemy.length; i++) {
            if (liste_enemy[i].getCurrent_health() > 0) {
                fin += 1; //si ennemi en vie
            }
        }


        if (fin == 0) {// si aucun ennemi en vie
            tourHero = 0;
            menu.setVisible(false);
            if (combat == 5) { //si dernier combat
                perdu.setVisible(true);
                perdu.setText("vous avez vaincu le donjon");
            } else {
                rec.setVisible(true);
            }
            textdégat.setVisible(false);
            textdégatrecu.setVisible(false);
            ien1.setVisible(false);
            ien2.setVisible(false);
            ien3.setVisible(false);
            ien4.setVisible(false);
            imhe1.setVisible(false);
            imhe2.setVisible(false);
            imhe3.setVisible(false);
            imhe4.setVisible(false);
            fl1.setVisible(false);
            fl2.setVisible(false);
            fl3.setVisible(false);
            fl4.setVisible(false);
            en1.setVisible(false);
            en2.setVisible(false);
            en3.setVisible(false);
            en4.setVisible(false);
            he1.setVisible(false);
            he2.setVisible(false);
            he3.setVisible(false);
            he4.setVisible(false);
        }


    }

    //----------------------------------------------------------------------------
    public void tourEnemi(Enemy[] liste_enemy, Hero[] liste_héros) throws InterruptedException, FileNotFoundException {
        String listedégat = new String();
        int fin = 0;
        for (int i = 0; i < liste_enemy.length; i++) {
            if (liste_enemy[i].getCurrent_health() > 0) { //si ennemi en vie
                boolean var3 = true;
                while (var3) {

                    Random r = new Random();
                    int n = 0; //attaque héro aléatoire
                    n = r.nextInt(liste_héros.length); //si vivant attaque héros random

                    if (liste_héros[n].getCurrent_health() > 0) {

                        double vie = liste_héros[n].getCurrent_health();
                        receiveDamage(charge(liste_enemy[i]), liste_héros[n]); //les ennemis n'attaquent pas le mort
                        var3 = false;
                        if (liste_héros[n].getCurrent_health() > 0) {
                            double diff = vie - liste_héros[n].getCurrent_health();
                            listedégat += diff + ", ";
                            affHero(liste_classe[n], n, true);
                        } else {
                            double diff = vie;
                            listedégat += diff + ", ";
                            liste_héros[n].setCurrent_health(0);
                            affHero(liste_classe[n], n, false);
                            for (int j = 0; j < liste_héros.length; j++) {//vérifie liste héro si vivant après chaque attaque
                                if (liste_héros[j].getCurrent_health() <= 0) {
                                    fin += 1;
                                }
                            }
                        }
                    } else {

                    }
                }
            }
        }
        writeData("dégats recus: " + listedégat, 1200, 350, textdégatrecu);

        if (fin == liste_héros.length) { //si tout héros mort
            perdu.setVisible(true);
            end.setVisible(true);
        }
    }

    @FXML
    void Rec(MouseEvent event) {
        rec.setVisible(false); //efface bouton recompense
        writeData(liste_classe[tourHero], 150, 100, reclabel);

        if (liste_classe[tourHero].equals("hunter")) { //affiche le text d'arme correspondant à la classe et au level
            recarme.setVisible(true);
            if (combat == 1) {
                recarme.setText("pistolet huilé 15 degat bonus et 10 dégat type feu");
            } else if (combat == 2) {
                recarme.setText("pistolet de Reaver 20 degat bonus et 15 dégat type terre");
            } else if (combat == 3) {
                recarme.setText("god pistol 25 degat bonus et 20 dégat type eau");
            }
            if (combat == 4) {
                recarme.setVisible(false);
            }
            recmana.setVisible(false);
        } else if (liste_classe[tourHero].equals("healer")) {
            recarme.setVisible(true);
            if (combat == 1) {
                recarme.setText("baton de cerisié 15 soin bonus");
            } else if (combat == 2) {
                recarme.setText("baton béni par un saint 20 soin bonus");
            } else if (combat == 3) {
                recarme.setText("Crosse papal avec une pomme d'éden 25 soin bonus");
            }
            if (combat == 4) {
                recarme.setVisible(false);
            }
            recmana.setVisible(true);
            recmana.setText("mana max +10");
        } else if (liste_classe[tourHero].equals("warrior")) {
            recarme.setVisible(true);
            if (combat == 1) {
                recarme.setText("épé de bonne facture 15 dégat bonus 10 dégat de type feuille");
            } else if (combat == 2) {
                recarme.setText("épé royale 20 dégat bonus 15 dégat de type eau");
            } else if (combat == 3) {
                recarme.setText("Excalibur 25 dégat bonus 20 dégat de type feu");
            }
            if (combat == 4) {
                recarme.setVisible(false);
            }
            recmana.setVisible(false);
        } else if (liste_classe[tourHero].equals("mage")) {
            recarme.setVisible(true);
            if (combat == 1) {
                recarme.setText("grimoire poussiéreux 15 dégat bonus 10 dégat de type feuille");
            } else if (combat == 2) {
                recarme.setText("grimoire oublié 20 dégat bonus 15 dégat de type eau");
            } else if (combat == 3) {
                recarme.setText("Necronomicon 25 dégat bonus 20 dégat de type terre");
            }
            if (combat == 4) {
                recarme.setVisible(false);
            }
            recmana.setVisible(true);
            recmana.setText("mana max +10");
        }
        recdef.setVisible(true);
        recdef.setText("def +10");
        recchance.setVisible(true);
        recchance.setText("chance +10");
        recnour.setVisible(true);
        recnour.setText("repas fait maison +50pv");
        recpotion.setVisible(true);
        if (combat == 2) {
            sortir.setText("s'enfoncer dans la crypte");
        }
        if (combat == 3) {
            sortir.setText("suivre les cris");
        }
        if (combat == 4) {
            sortir.setText("confronter la source");
        }
    }

    @FXML
    void rdef(MouseEvent event) {
        liste_héros[tourHero].setDef(liste_héros[tourHero].getDef() + 10);
        liste_héros[tourHero].setCurrent_def(liste_héros[tourHero].getDef());
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void rchance(MouseEvent event) {
        liste_héros[tourHero].setChance(liste_héros[tourHero].getChance() + 10);
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void rmana(MouseEvent event) {
        liste_héros[tourHero].setMagie(liste_héros[tourHero].getMagie() + 10);
        liste_héros[tourHero].setCurrent_magie(liste_héros[tourHero].getMagie());
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void rnour(MouseEvent event) {
        consommable food = new consommable();
        food.setClasse("Food");
        food.setName("fin de la zone");
        food.setSoin(50);
        liste_héros[tourHero].addConsumable(food);
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void rpot1(ActionEvent event) {
        consommable potion = new consommable();
        potion.setClasse("Potion");
        potion.setName("potion de mana");
        potion.setMana(10);
        liste_héros[tourHero].addConsumable(potion);
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void rpot2(ActionEvent event) {
        consommable potion = new consommable();
        potion.setClasse("Potion");
        potion.setName("potion de vie");
        potion.setSoin(40);
        liste_héros[tourHero].addConsumable(potion);
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void rpot3(ActionEvent event) {
        consommable potion = new consommable();
        potion.setClasse("Potion");
        potion.setName("potion de dégat");
        potion.setBonus_degat(10);
        liste_héros[tourHero].addConsumable(potion);
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void rpot4(ActionEvent event) {
        consommable potion = new consommable();
        potion.setClasse("Potion");
        potion.setName("potion d'armure");
        potion.setBonus_def(50);
        liste_héros[tourHero].addConsumable(potion);
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }


    @FXML
    void rarme(MouseEvent event) {
        if (liste_classe[tourHero].equals("healer")) {
            Weapon arme_equip = liste_héros[tourHero].getInventaire_weapon()[liste_héros[tourHero].getWeapon_equipped()];
            if (combat == 1) {
                arme_equip.setBonus_soin(15);
                arme_equip.setName("Baton de cerisié");
                arme_equip.setType("terre");
            } else if (combat == 2) {
                arme_equip.setBonus_soin(20);
                arme_equip.setName("Baton béni par un saint");
                arme_equip.setType("feu");
            } else if (combat == 3) {
                arme_equip.setBonus_soin(25);
                arme_equip.setName("Crosse papal avec une pomme d'éden");
                arme_equip.setType("feuille");
            }
        } else if (liste_classe[tourHero].equals("hunter")) {
            Weapon arme_equip = liste_héros[tourHero].getInventaire_weapon()[liste_héros[tourHero].getWeapon_equipped()];
            if (combat == 1) {
                arme_equip.setBonus_degat(15);
                arme_equip.setName("pistolet huilé");
                arme_equip.setType("feu");
                arme_equip.setType_degat(10);
            } else if (combat == 2) {
                arme_equip.setBonus_degat(20);
                arme_equip.setName("Pistolet de Reaver");
                arme_equip.setType("terrre");
                arme_equip.setType_degat(15);
            } else if (combat == 3) {
                arme_equip.setBonus_degat(15);
                arme_equip.setName("fod pistol");
                arme_equip.setType("eau");
                arme_equip.setType_degat(20);
            }
        } else if (liste_classe[tourHero].equals("warrior")) {
            Weapon arme_equip = liste_héros[tourHero].getInventaire_weapon()[liste_héros[tourHero].getWeapon_equipped()];
            if (combat == 1) {
                arme_equip.setBonus_degat(15);
                arme_equip.setName("Épé de bonne facture");
                arme_equip.setType("feuille");
                arme_equip.setType_degat(10);
                liste_héros[tourHero].addWeapon(arme_equip);
            } else if (combat == 2) {
                arme_equip.setBonus_degat(20);
                arme_equip.setName("Épé royale");
                arme_equip.setType("eau");
                arme_equip.setType_degat(15);
            } else if (combat == 3) {
                arme_equip.setBonus_degat(25);
                arme_equip.setName("Excalibur");
                arme_equip.setType("feu");
                arme_equip.setType_degat(20);
            }
        } else if (liste_classe[tourHero].equals("mage")) {
            Weapon arme_equip = liste_héros[tourHero].getInventaire_weapon()[liste_héros[tourHero].getWeapon_equipped()];
            if (combat == 1) {
                arme_equip.setBonus_degat(15);
                arme_equip.setName("Grimoire poussièreux");
                arme_equip.setType("feuille");
                arme_equip.setType_degat(10);
            } else if (combat == 2) {
                arme_equip.setBonus_degat(20);
                arme_equip.setName("Grimoire oublié");
                arme_equip.setType("eau");
                arme_equip.setType_degat(15);
            } else if (combat == 3) {
                arme_equip.setBonus_degat(25);
                arme_equip.setName("Necronomicon");
                arme_equip.setType("terre");
                arme_equip.setType_degat(20);
            }
        }
        tourHero += 1;
        reclabel.setVisible(false);
        recchance.setVisible(false);
        recdef.setVisible(false);
        recchance.setVisible(false);
        recnour.setVisible(false);
        recmana.setVisible(false);
        recarme.setVisible(false);
        recpotion.setVisible(false);
        if (tourHero == liste_héros.length) {
            writeData("fin de la zone", 150, 100, reclabel);
            sortir.setVisible(true);
        } else {
            rec.setVisible(true);
        }
    }

    @FXML
    void sortir(MouseEvent event) throws IOException {
        reclabel.setVisible(false);
        sortir.setVisible(false);
        but1.setVisible(true);
        if (combat == 1) {
            Ci10.setText("Brigand Hunter"); //change nom des ennemis dans item selon combat
            Ci11.setText("Brigand Hunter");
            Ci12.setText("Brigand Hunter");
            Ci13.setText("Brigand Hunter");
            Ci14.setText("Brigand Hunter");
            Ci15.setText("Brigand Hunter");
            Ci16.setText("Brigand Hunter");
            Ci17.setText("Brigand Hunter");

            Ci20.setText("Brigand Raider");
            Ci21.setText("Brigand Raider");
            Ci22.setText("Brigand Raider");
            Ci23.setText("Brigand Raider");
            Ci24.setText("Brigand Raider");
            Ci25.setText("Brigand Raider");
            Ci26.setText("Brigand Raider");
            Ci27.setText("Brigand Raider");

            Ci30.setText("Cutthroat");
            Ci31.setText("Cutthroat");
            Ci32.setText("Cutthroat");
            Ci33.setText("Cutthroat");
            Ci34.setText("Cutthroat");
            Ci35.setText("Cutthroat");
            Ci36.setText("Cutthroat");
            Ci37.setText("Cutthroat");

            Ci40.setText("Vvulf");
            Ci41.setText("Vvulf");
            Ci42.setText("Vvulf");
            Ci43.setText("Vvulf");
            Ci44.setText("Vvulf");
            Ci45.setText("Vvulf");
            Ci46.setText("Vvulf");
            Ci47.setText("Vvulf");

            but1.setText("entrer dans la crypte");
            String path = "src/main/resources/picture/dungeon2/dungeon2.png";
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            fond.setImage(image);
        } else if (combat == 2) {
            Ci10.setText("Spitter ");
            Ci11.setText("Spitter ");
            Ci12.setText("Spitter ");
            Ci13.setText("Spitter ");
            Ci14.setText("Spitter ");
            Ci15.setText("Spitter ");
            Ci16.setText("Spitter ");
            Ci17.setText("Spitter ");

            Ci20.setText("Cultist ");
            Ci21.setText("Cultist ");
            Ci22.setText("Cultist ");
            Ci23.setText("Cultist ");
            Ci24.setText("Cultist ");
            Ci25.setText("Cultist ");
            Ci26.setText("Cultist ");
            Ci27.setText("Cultist ");

            Ci30.setText("Gargoyle");
            Ci31.setText("Gargoyle");
            Ci32.setText("Gargoyle");
            Ci33.setText("Gargoyle");
            Ci34.setText("Gargoyle");
            Ci35.setText("Gargoyle");
            Ci36.setText("Gargoyle");
            Ci37.setText("Gargoyle");

            Ci40.setText("Ghoul");
            Ci41.setText("Ghoul");
            Ci42.setText("Ghoul");
            Ci43.setText("Ghoul");
            Ci44.setText("Ghoul");
            Ci45.setText("Ghoul");
            Ci46.setText("Ghoul");
            Ci47.setText("Ghoul");
            but1.setText("avancer dans les sombres couloirs");
            String path = "src/main/resources/picture/dungeon3/dungeon3.png";
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            fond.setImage(image);
        } else if (combat == 3) {
            Ci10.setText("Swine Drummer ");
            Ci11.setText("Swine Drummer ");
            Ci12.setText("Swine Drummer ");
            Ci13.setText("Swine Drummer ");
            Ci14.setText("Swine Drummer ");
            Ci15.setText("Swine Drummer ");
            Ci16.setText("Swine Drummer ");
            Ci17.setText("Swine Drummer ");

            Ci20.setText("Swine Slasher ");
            Ci21.setText("Swine Slasher ");
            Ci22.setText("Swine Slasher ");
            Ci23.setText("Swine Slasher ");
            Ci24.setText("Swine Slasher ");
            Ci25.setText("Swine Slasher ");
            Ci26.setText("Swine Slasher ");
            Ci27.setText("Swine Slasher ");

            Ci30.setText("Swine Skiver");
            Ci31.setText("Swine Skiver");
            Ci32.setText("Swine Skiver");
            Ci33.setText("Swine Skiver");
            Ci34.setText("Swine Skiver");
            Ci35.setText("Swine Skiver");
            Ci36.setText("Swine Skiver");
            Ci37.setText("Swine Skiver");

            Ci40.setText("Swine Chopper");
            Ci41.setText("Swine Chopper");
            Ci42.setText("Swine Chopper");
            Ci43.setText("Swine Chopper");
            Ci44.setText("Swine Chopper");
            Ci45.setText("Swine Chopper");
            Ci46.setText("Swine Chopper");
            Ci47.setText("Swine Chopper");
            but1.setText("chercher la source des cris");
            String path = "src/main/resources/picture/dungeon4/dungeon4.png";
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            fond.setImage(image);
        } else if (combat == 4) {
            but1.setText("contempler l'horreur");

            String path = "src/main/resources/picture/finaldungeon/Darkest dungeon.png";
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            fond.setImage(image);
        }
        combat += 1;
    }

}