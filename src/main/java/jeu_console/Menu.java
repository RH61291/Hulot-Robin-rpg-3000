package jeu_console;

import jeu_console.Combattant.Enemy;
import jeu_console.Combattant.Hero.Hero;
import jeu_console.Combattant.Hero.cc_distance.Hunter;
import jeu_console.Combattant.Hero.cc_distance.Warrior;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Healer;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Mage;
import jeu_console.Item.arme_potion.consommable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static jeu_console.Combattant.Combattant.receiveDamage;
import static jeu_console.Combattant.Hero.cc_distance.Hunter.Attaque_au_couteau;
import static jeu_console.Combattant.Hero.cc_distance.Hunter.Tir;
import static jeu_console.Combattant.Hero.cc_distance.Warrior.Attaque;
import static jeu_console.Combattant.Hero.cc_distance.Warrior.Berserk;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Healer.*;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Mage.*;
import static jeu_console.Item.arme_potion.conso.Food.manger;
import static jeu_console.Item.arme_potion.conso.Potion.BoireUnePotion;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void combat(Hero hero, String classe, String nom, Enemy[] listeEnemy, Hero[] liste_Hero, String[] liste_classe, String[] liste_nom) throws IOException {
        String choix = "";
        int compteurNour = 0;
        int compteurPot = 0;

        while (true) {
            if (classe.equals("Healer")) {

                System.out.println("Quelle action doit faire " + classe + " " + nom + " "+ hero.getCurrent_magie()+" mana restant:\nSoigner(2 mana), Soin de groupe(3 mana)," +
                        " Réssusciter(4 mana), Manger, Boire une potion, Passer");
            }
            if (classe.equals("Mage")) {

                System.out.println("Quelle action doit faire " + classe + " " + nom +" "+ hero.getCurrent_magie()+" mana restant:\nBoule de feu(2 mana), Lame d'eau(2 mana)," +
                        "Séisme(2 mana), Tranche herbe(2 mana), Manger, Boire une potion, Passer");
            }
            if (classe.equals("Hunter")) {

                System.out.println("Quelle action doit faire " + classe + " " + nom + "?:\nTir, Attaque au couteau, Manger, Boire une potion, Passer");
            }
            if (classe.equals("Warrior")) {

                System.out.println("Quelle action doit faire " + classe + " " + nom + "?:\nAttaque, Berserk (-50% de vie, x2 dégat), Manger, Boire une potion, Passer");
            }

            choix = br.readLine();
            //si choix valide alors break

            if (choix.equals("Attaque") || choix.equals("Attaque au couteau") ||choix.equals("Berserk") || choix.equals("Passer")) {

                break;
            }

            if (choix.equals("Tir")) {

                if (hero.getNbfleche() >= 1) { //si a plus d'une flèche

                    break;
                }
                else {

                    System.out.println("Manque de flèche");
                }
            }

            if ((choix.equals("Soigner") || choix.equals("Boule de feu") || choix.equals("Lame d'eau")|| choix.equals("Séisme")|| choix.equals("Tranche herbe"))) {

                if (hero.getCurrent_magie() >= 2) {

                    break;
                }
                else {

                    System.out.println("pas assez de magie");
                }
            }

            if (choix.equals("Soin de groupe") ){

                if (hero.getCurrent_magie() >= 3) {

                    break;
                }
                else {

                    System.out.println("pas assez de magie");
                }
            }

            if (choix.equals("Manger")) {

                consommable[] listeConso = hero.getInventaire_consumable();
                for (int i = 0; i < listeConso.length; i++) {

                    if (listeConso[i].getClasse() == null) {

                    }
                    else {

                        if (listeConso[i].getClasse().equals("Food")) {
                            compteurNour += 1;
                        }
                    }
                }
                if (compteurNour != 0) {

                    break;
                }
                else {

                    System.out.println("pas de nourriture dans l'inventaire");
                }
            }

            if (choix.equals("Boire une potion")) {

                consommable[] listeConso = hero.getInventaire_consumable();
                for (int i = 0; i < listeConso.length; i++) {

                    if (listeConso[i].getClasse() == null) {

                    }
                    else {

                        if (listeConso[i].getClasse().equals("Potion")) {

                            compteurPot += 1;
                        }
                    }
                }
                if (compteurPot != 0) {

                    break;
                } else {

                    System.out.println("pas de potion dans l'inventaire");
                }
            }

            if (choix.equals("Réssusciter")) {

                int compteur = 0;
                if (hero.getCurrent_magie() >= 4) {

                    for (int i = 0; i < liste_Hero.length; i++) {

                        if (liste_Hero[i].getCurrent_health() <= 0) {

                            compteur += 1;
                        }
                    }
                    if (compteur >= 1) {

                        break;
                    }
                    else {

                        System.out.println("pas de personne a réssusciter");
                    }
                }
                else {

                    System.out.println("pas assez de magie");
                }
            }

            else {
                System.out.println("Mauvaise action");
            }
        } //donne le choix

        double[] dégats = new double[5];
        int atkChoice = -1;

        // en fonction du choix effectue l'acte et choisi la cible si nécessaire


        if (choix.equals("Manger")) {

            manger(hero);
            System.out.println("----------------------------\n");
        }

        if (choix.equals("Passer")){
        }

        if (choix.equals("Boire une potion")) {

            BoireUnePotion(hero);
            System.out.println("l'effet des potions s'estompera à la fin du combat");
            System.out.println("----------------------------\n");
        }

        if (choix.equals("Attaque au couteau")) {

            dégats = Attaque_au_couteau((Hunter) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }
            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();
                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    }
                    else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        }
                        else {

                            break;
                        }
                    }
                }
                catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                }
            }
            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }
        }

        if (choix.equals("Attaque")) {

            dégats = Attaque((Warrior) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }
            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();
                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    }
                    else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        }
                        else {

                            break;
                        }
                    }
                } catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                }
            }
            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }

        }

        if (choix.equals("Berserk")) {

            dégats = Berserk((Warrior) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }
            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();
                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    }
                    else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        }
                        else {

                            break;
                        }
                    }
                }
                catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                }
            }
            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }

        }

        if (choix.equals("Tir")) {

            dégats = Tir((Hunter) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }
            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();
                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    }
                    else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        }
                        else {

                            break;
                        }
                    }
                }
                catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                    ;
                }
            }
            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }
        }

        if (choix.equals("Boule de feu")) {

            dégats = bouleDeFeu((Mage) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }
            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();
                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    }
                    else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        }
                        else {

                            break;
                        }
                    }
                } catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                }
            }
            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }
        }

        if (choix.equals("Soigner")) {
            int cible = 0;

            while (true) {

                try {

                    System.out.println("choissisez la cible (numéro)");
                    for (int i = 0; i < liste_Hero.length; i++) {

                        System.out.println(liste_classe[i] + " " + liste_nom[i] + " (" + i + ") " + liste_Hero[i].getCurrent_health() + "/" + liste_Hero[i].getHealth() + " pv");
                    }
                    cible = sc.nextInt();
                    if (cible > liste_Hero.length - 1 || cible < 0) {

                        System.out.println("Mauvais chiffre");
                    }
                    else {

                        if (liste_Hero[cible].getCurrent_health() == 0) {

                            System.out.println("ne peu soigner un mort");
                        }
                        else {

                            break;
                        }
                    }
                } catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                }
            }
            System.out.println("----------------------------\n");
            heal((Healer) hero, liste_Hero[cible]);
        }

        if (choix.equals("Lame d'eau")) {

            dégats = lameDeau((Mage) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }

            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();
                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    }
                    else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        }
                        else {

                            break;
                        }
                    }
                }
                catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");

                }
            }

            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }
        }

        if (choix.equals("Réssusciter")) {
            int cible = 0;

            while (true) {

                try {

                    System.out.println("choissisez la cible (numéro)");
                    for (int i = 0; i < liste_Hero.length; i++) {

                        if (liste_Hero[i].getCurrent_health() <= 0) {

                            System.out.println(liste_classe[i] + " " + liste_nom[i] + " (" + i + ") " + liste_Hero[i].getCurrent_health() + "/" + liste_Hero[i].getHealth() + " pv");
                        }
                    }
                    cible = sc.nextInt();
                    if (cible > liste_Hero.length - 1 || cible < 0) {

                        System.out.println("Mauvais chiffre");
                    }
                    else {

                        break;
                    }
                }
                catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                }
            }
            ressurect((Healer) hero, liste_Hero[cible]);
        }

        if (choix.equals("Séisme")) {

            dégats = séisme((Mage) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }
            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();

                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    }
                    else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        }
                        else {

                            break;
                        }
                    }
                }
                catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                    ;
                }
            }
            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }
        }

        if (choix.equals("Tranche herbe")) {

            dégats = feuilleLame((Mage) hero);
            System.out.println("");
            System.out.println("voici vos ennemis");

            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv," +
                        " de type " + listeEnemy[i].getType());
            }
            while (true) {

                try {

                    System.out.println("choisissez votre cible (numéro)");
                    atkChoice = sc.nextInt();
                    if (atkChoice > listeEnemy.length - 1) {

                        System.out.println("mauvais chiffre");
                    } else {

                        if (listeEnemy[atkChoice].getCurrent_health() <= 0) {

                            System.out.println("la cible est déja morte");
                        } else {

                            break;
                        }
                    }
                } catch (Exception e) {

                    sc.nextLine();
                    System.out.println("donner un chiffre");
                    ;
                }
            }
            receiveDamage(dégats, listeEnemy[atkChoice]);
            if (listeEnemy[atkChoice].getCurrent_health() < 0) {

                listeEnemy[atkChoice].setCurrent_health(0);
            }
            System.out.println("----------------------------\n");
            for (int i = 0; i < listeEnemy.length; i++) {

                System.out.println("Démon (" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv");
            }
        }

        if (choix.equals("Soin de groupe")) {

            int cible = 0;
            System.out.println("----------------------------");
            healGR((Healer) hero, liste_Hero);
        }
    }
}

