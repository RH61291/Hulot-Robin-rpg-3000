package jeu_console.Combattant.Hero.cc_distance;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.conso.Potion;
import jeu_console.Item.arme_potion.consommable;

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
            damage = 2 * (warrior.getDegat_base() + arme_equip.getBonus_degat());
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

        warrior.setCurrent_health(warrior.getCurrent_health() / 2);
        return tab_dégat;
    } // mais avec *2 de dégat et perte de la moitié de sa vie

    public static Hero gWarrior(Hero[] heros, Weapon[] liste_arme, int i) {
        heros[i] = new Warrior();
        heros[i].setChance(10);
        heros[i].setDegat_base(20);
        heros[i].setDegat_fond(heros[i].getDegat_base());
        heros[i].setHealth(200);
        heros[i].setCurrent_health(heros[i].getHealth());
        heros[i].setDef(40);
        heros[i].setCurrent_def(heros[i].getDef());
        heros[i].setType("terre");


        //initialisation de l'inventaire (arme)
        heros[i].initialise_inventory();
        liste_arme[i] = new Weapon();
        liste_arme[i].setBonus_degat(10);
        liste_arme[i].setName("lame d'aventurier");
        liste_arme[i].setType("terre");
        liste_arme[i].setType_degat(5);
        heros[i].addWeapon(liste_arme[i]);

        //initialisation de l'inventaire potion
        consommable food = new consommable();
        food.setName("boeuf");
        food.setClasse("Food");
        food.setSoin(25);
        heros[i].addConsumable(food);

        Potion potion = new Potion();
        potion.setSoin(40);
        potion.setClasse("Potion");
        potion.setName("potion de vie");

        Potion potion1 = new Potion();
        potion1.setBonus_def(10);
        potion1.setClasse("Potion");
        potion1.setName("potion d'armure");

        Potion potion2 = new Potion();
        potion2.setBonus_degat(10);
        potion2.setClasse("Potion");
        potion2.setName("potion de dégat");

        heros[i].addConsumable(potion);
        heros[i].addConsumable(potion1);
        heros[i].addConsumable(potion2);
        return heros[i];
    }


}
