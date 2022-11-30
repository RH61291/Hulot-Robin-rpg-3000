package jeu_console;

import jeu_console.Combattant.Enemy;
import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import static jeu_console.Combattant.Combattant.receiveDamage;
import static jeu_console.Combattant.Enemy.*;
import static jeu_console.Combattant.Hero.cc_distance.Hunter.gHunter;
import static jeu_console.Combattant.Hero.cc_distance.Warrior.gWarrior;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Healer.gHealer;
import static jeu_console.Combattant.Hero.cc_distance.sorcier.Mage.gMage;

public class Game {
    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Menu menus = new Menu();
    private static int max_ennemi;
    private static int nombre_ennemi;


    public static void playGame() throws IOException {

        int nombre_heros = 0;
        while (true) {

            try {

                System.out.println("combien de heros (entre 1 et 4): \n----------------------------");
                nombre_heros = sc.nextInt(); //nombre de heros
                if (nombre_heros > 0 && nombre_heros <= 4) {
                    break;
                }
            } catch (Exception e) {

                sc.nextLine();
                System.out.println("donner un entier entre 1 et 4\n");
            }
        } //choix nombre de héros

        System.out.println("votre equipe est composée de " + nombre_heros + " heros");
        System.out.println("----------------------------");


        Hero[] heros = new Hero[nombre_heros]; //liste des héros
        max_ennemi = nombre_heros;
        nombre_ennemi = max_ennemi;


        String[] classe_heros = new String[nombre_heros]; //liste des classes
        String[] noms_heros = new String[nombre_heros]; //liste des noms
        System.out.println("\ndonner leurs classes (Warrior,Hunter,Healer,Mage) et leurs noms: \n----------------------------");


        sc.nextLine();
        Weapon[] liste_arme = new Weapon[nombre_heros];
        for (int i = 0; i < nombre_heros; i++) {

            System.out.println("nouveau heros");
            while (true) {

                System.out.println("sa classe");
                classe_heros[i] = sc.nextLine();
                if (classe_heros[i].equals("Warrior") || classe_heros[i].equals("Hunter") || classe_heros[i].equals("Healer") || classe_heros[i].equals("Mage")) {

                    break;
                } else {

                    System.out.println("cette classe n'existe pas");
                }
            }

            System.out.println("et son nom");
            noms_heros[i] = sc.nextLine();

            if (classe_heros[i].equals("Warrior")) {
                heros[i] = gWarrior(heros, liste_arme, i);
            }

            if (classe_heros[i].equals("Hunter")) {
                heros[i] = gHunter(heros, liste_arme, i);
            }

            if (classe_heros[i].equals("Healer")) {
                heros[i] = gHealer(heros, liste_arme, i);
            }

            if (classe_heros[i].equals("Mage")) {
                heros[i] = gMage(heros, liste_arme, i);
            }

        }//attribution classe et nom
        System.out.println("----------------------------");


        System.out.println("\n Voici votre équipe :\n----------------------------");
        for (int i = 0; i < nombre_heros; i++) {

            System.out.println(noms_heros[i] + " " + classe_heros[i]);
            if (classe_heros[i].equals("Hunter")) {

                System.out.println(heros[i].getCurrent_health() + "/" + heros[i].getHealth() + " vie, " + heros[i].getDef() + " armure, type " + heros[i].getType() +
                        ", dégat de base avec arme " + (heros[i].getDegat_base() + liste_arme[i].getBonus_degat()));
            }
            if (classe_heros[i].equals("Mage")) {

                System.out.println(heros[i].getCurrent_health() + "/" + heros[i].getHealth() + " vie, " + heros[i].getDef() + " armure, type " + heros[i].getType() + " et mana " + heros[i].getMagie() +
                        ", dégat de base avec arme " + (heros[i].getDegat_base() + liste_arme[i].getBonus_degat()));
            }
            if (classe_heros[i].equals("Healer")) {

                System.out.println(heros[i].getCurrent_health() + "/" + heros[i].getHealth() + " vie, " + heros[i].getDef() + " armure, type " + heros[i].getType() + " et mana " + heros[i].getMagie() +
                        ", soin de base avec arme " + (heros[i].getSoin_base() + liste_arme[i].getBonus_soin()));
            }
            if (classe_heros[i].equals("Warrior")) {

                System.out.println(heros[i].getCurrent_health() + "/" + heros[i].getHealth() + " vie, " + heros[i].getDef() + " armure, type " + heros[i].getType() +
                        ", dégat de base avec arme " + (heros[i].getDegat_base() + liste_arme[i].getBonus_degat()));
            }
            System.out.println("Avec l'arme " + liste_arme[i].getName() + " de type " + liste_arme[i].getType());
            System.out.println("il a aussi un morceau de boeuf et quelques potions");
            System.out.println("----------------------------");
        }//montre l'équipe et leurs stats


        int compteurCombat = 0; //nombre de combat effectué
        boolean var2 = true; //booléen pour la boucle des combat
        int fin = 0; //variable donnant la fin du jeu

        Enemy Boss = genBoss(); //génération de l'unique boss


        while (var2) {

            System.out.println("\nvos ennemis :");
            Enemy[] listeEnemy = new Enemy[nombre_ennemi];

            if (compteurCombat == 4) {

                System.out.println("----------------------------");
                System.out.println("Démon suprème " + Boss.getCurrent_health() + "/" + Boss.getHealth() + " pv" +
                        "; de type " + Boss.getType());
                //montrer les ennemis
                System.out.println("----------------------------");

            } //si dernier combat
            else {
                System.out.println("----------------------------");

                for (int i = 0; i < nombre_ennemi; i++) {

                    listeEnemy[i] = genEnemy(compteurCombat);
                    System.out.println("Démon(" + i + ") " + listeEnemy[i].getCurrent_health() + "/" + listeEnemy[i].getHealth() + " pv" +
                            "; de type " + listeEnemy[i].getType());
                } //montrer les ennemis
                System.out.println("----------------------------");
            } //génération des ennemis


            int compteurHero = 0; //compteur héros en vie
            int compteurEnemy = 0; // compteur ennemis en vie
            boolean var = true; //booléen gérant la boucle du combat


            while (var) {

                compteurEnemy = 0;
                System.out.println("\n ----------------------------");
                for (int i = 0; i < nombre_heros; i++) {

                    if (heros[i].getCurrent_health() > 0) { //si en vie

                        menus.combat(heros[i], classe_heros[i], noms_heros[i], listeEnemy, heros, classe_heros, noms_heros); //action des héros
                        compteurEnemy = 0;

                        for (int j = 0; j < nombre_ennemi; j++) {

                            if (listeEnemy[j].getCurrent_health() <= 0) {//si ennemi mort

                                compteurEnemy += 1;
                            }
                        }
                        if (compteurEnemy == nombre_ennemi) {

                            System.out.println("\nvous avez gagné");
                            var = false;
                            break;
                        }
                    } else {

                    }
                } //tour des héros
                System.out.println("----------------------------\n");


                int comp = 0; //compteru pour gérer affichege de ligne en fonction de si il y a des ennemis vivant
                if (compteurCombat == 4) { //si dernier combat

                    if (Boss.getCurrent_health() <= 0) {

                        compteurEnemy += 1;
                    } else {

                        System.out.println("----------------------------");
                        comp += 1;
                        boolean var3 = true; //booléen pour la boucle du choix de la cible
                        while (var3) {

                            Random r = new Random();
                            int n = 0;
                            n = r.nextInt(nombre_heros); //si vivant attaque héros random

                            if (heros[n].getCurrent_health() > 0) {

                                System.out.println(classe_heros[n] + " " + noms_heros[n] + " a été attaqué");
                                receiveDamage(charge(Boss), heros[n]); //les ennemis n'attaque pas le morts
                                var3 = false;
                            } else {
                            }
                        }
                    }
                    if (comp != 0) {
                        System.out.println("----------------------------\n");
                    }

                } else {
                    for (int i = 0; i < nombre_ennemi; i++) {

                        if (listeEnemy[i].getCurrent_health() <= 0) { //si ennemi mort

                            compteurEnemy += 1;
                        } else {

                            System.out.println("----------------------------");
                            comp += 1;

                            boolean var3 = true;
                            while (var3) {

                                Random r = new Random();
                                int n = 0;
                                n = r.nextInt(nombre_heros); //si vivant attaque héros random

                                if (heros[n].getCurrent_health() > 0) {

                                    System.out.println(classe_heros[n] + " " + noms_heros[n] + " a été attaqué");
                                    receiveDamage(charge(listeEnemy[i]), heros[n]); //les ennemis n'attaque pas le morts
                                    var3 = false;
                                } else {

                                }
                            }
                        }
                        if (comp != 0) {
                            System.out.println("----------------------------\n");
                        }
                    }
                } //tour des ennemis


                compteurHero = 0;
                for (int i = 0; i < nombre_heros; i++) { //affichage vie héros et regard si mort

                    if (heros[i].getCurrent_health() <= 0) {

                        System.out.println(classe_heros[i] + " " + noms_heros[i] + " est mort");
                        compteurHero += 1;
                    } else {

                        if (classe_heros[i].equals("Mage") || classe_heros[i].equals("Healer")) {

                            System.out.println(classe_heros[i] + " " + noms_heros[i] + " a " + heros[i].getCurrent_health() + "/" + heros[i].getHealth()
                                    + " pv et " + heros[i].getCurrent_magie() + "/" + heros[i].getMagie() + " mana");
                        }
                        if (classe_heros[i].equals("Hunter")) {

                            System.out.println(classe_heros[i] + " " + noms_heros[i] + " a " + heros[i].getCurrent_health() + "/" + heros[i].getHealth()
                                    + " pv et " + heros[i].getNbfleche() + " flèches");
                        }
                        if (classe_heros[i].equals(("Warrior"))) {

                            System.out.println(classe_heros[i] + " " + noms_heros[i] + " a " + heros[i].getCurrent_health() + "/" + heros[i].getHealth() + " pv");
                        }
                    }
                } //affichage vie après combat et morts


                if (compteurHero == nombre_heros) {

                    System.out.println("");
                    System.out.println("\nvous avez perdu");
                    var2 = false;
                    fin = 1;
                    var = false;
                }// si tous les héros sont mort
                System.out.println("----------------------------\n");


            } //déroulement d'un combat

            compteurCombat += 1;
            System.out.println("fin " + compteurCombat + " combats");

            for (int i = 0; i < heros.length; i++) {

                if (heros[i].getCurrent_health() >= 0) {

                    heros[i].setCurrent_def(heros[i].getDef());
                    heros[i].setDegat_base(heros[i].getDegat_fond());

                    if (classe_heros[i].equals("Mage") || classe_heros[i].equals("Healer")) {

                        if (heros[i].getCurrent_magie() >= heros[i].getMagie() / 2) {

                            System.out.println(classe_heros[i] + " " + noms_heros[i] + " a regagné " + (heros[i].getMagie() - heros[i].getCurrent_magie()) + " mana");
                            heros[i].setCurrent_magie(heros[i].getMagie());
                        } else {

                            System.out.println(classe_heros[i] + " " + noms_heros[i] + " a regagné " + ((heros[i].getMagie() / 2 + heros[i].getCurrent_magie()) - heros[i].getCurrent_magie()) + " mana");
                            heros[i].setCurrent_magie(heros[i].getMagie() / 2 + heros[i].getCurrent_magie());
                        }
                    }
                    if (classe_heros[i].equals("Hunter")) {

                        System.out.println(classe_heros[i] + " " + noms_heros[i] + " a regagné " + 5 + " flèche");
                        heros[i].setCurrent_magie(heros[i].getMagie());
                        heros[i].setNbfleche(heros[i].getNbfleche() + 5);
                    }
                }
            } //regain magie, flèche et fin effet potion après combat

            if (compteurCombat == 4) {

                System.out.println("voici le boss");
            }

            if (compteurCombat >= 5) {
                fin = -1;
                var2 = false;
            } //si le nombre de combat est atteint

            for (int i = 0; i < heros.length; i++) {

                if (heros[i].getCurrent_health() >= 0) {
                    System.out.println(" le héro " + noms_heros[i] + " de classe " + classe_heros[i] + " récupère sa récompense");
                    Récompense.recompense(heros[i], classe_heros[i], compteurCombat);
                }
            } //récompense de fin de combat

        } //tant que le nombre de combat n'est pas 5 ou une défaite


        if (fin == -1) {
            System.out.println("\nle jeu est fini, vous avez gagné");
        }
        if (fin == 1) {
            System.out.println("\nle jeu est fini, vous avez perdu");
        }
    }
}


