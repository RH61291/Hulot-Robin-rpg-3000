package jeu_console.Combattant.Hero.cc_distance;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;

import java.util.Random;
import java.util.Scanner;

public class Warrior extends Hero {
    Scanner sc = new Scanner(System.in);


    public static double[] Attaque(Warrior warrior) {
        Random r = new Random();
        int n = r.nextInt(100);

        Weapon arme_equip = warrior.getInventaire_weapon()[warrior.getWeapon_equipped()]; //récupère arme
        int damage = 0;

        if (n < warrior.getChance()) {

            damage = 2 * (warrior.getDegat_base() + arme_equip.getBonus_degat());
            System.out.println("coup critique"); //si critique

        } else {
            damage = warrior.getDegat_base() + arme_equip.getBonus_degat();
        }

        double[] tab_dégat = new double[5];
        tab_dégat[0] = damage;
        tab_dégat[1] = 0;
        tab_dégat[2] = 0;
        tab_dégat[3] = 0;
        tab_dégat[4] = 0;


        switch (arme_equip.getType()) {
            case "feu" -> tab_dégat[1] = arme_equip.getType_degat();
            case "eau" -> tab_dégat[2] = arme_equip.getType_degat();
            case "feuille" -> tab_dégat[3] = arme_equip.getType_degat();
            case "terre" -> tab_dégat[4] = arme_equip.getType_degat();
        }


        return tab_dégat;
    }

    public static double[] Berserk(Warrior warrior) {
        Random r = new Random();
        int n = r.nextInt(100);

        Weapon arme_equip = warrior.getInventaire_weapon()[warrior.getWeapon_equipped()];
        int damage = 0;

        if (n < warrior.getChance()) {
            damage = 4 * (warrior.getDegat_base() + arme_equip.getBonus_degat());
            System.out.println("coup critique");
        } else {
            damage = 2*(warrior.getDegat_base() + arme_equip.getBonus_degat());
        }

        double[] tab_dégat = new double[5];
        tab_dégat[0] = damage;
        tab_dégat[1] = 0;
        tab_dégat[2] = 0;
        tab_dégat[3] = 0;
        tab_dégat[4] = 0;


        switch (arme_equip.getType()) {
            case "feu" -> tab_dégat[1] = arme_equip.getType_degat();
            case "eau" -> tab_dégat[2] = arme_equip.getType_degat();
            case "feuille" -> tab_dégat[3] = arme_equip.getType_degat();
            case "terre" -> tab_dégat[4] = arme_equip.getType_degat();
        }

        warrior.setCurrent_health(warrior.getCurrent_health()/2);
        return tab_dégat;
    } // mais avec *2 de dégat et perte de la moitié de sa vie



}
