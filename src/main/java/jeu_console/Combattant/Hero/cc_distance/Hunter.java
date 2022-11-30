package jeu_console.Combattant.Hero.cc_distance;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.conso.Potion;
import jeu_console.Item.arme_potion.consommable;

import java.util.Random;
import java.util.Scanner;


public class Hunter extends Hero {
    Scanner sc = new Scanner(System.in);

    private Integer nbfleche;

    public static double[] Tir(Hunter hunter) {
        Random r = new Random();
        int n = r.nextInt(100);

        int damage = 0;
        Weapon arme_equip = hunter.getInventaire_weapon()[hunter.getWeapon_equipped()]; //récupère l'arme

        if (n < hunter.getChance()) {
            damage = 2 * ((hunter.getDegat_base() + arme_equip.getBonus_degat())); //si critique
            System.out.println("coup critique");

        } else {
            damage = ((hunter.getDegat_base() + arme_equip.getBonus_degat()));
        }

        double[] tab_dégat = new double[5]; //dégat en dégat pur pouvant etre réduit
        tab_dégat[0] = damage;
        tab_dégat[1] = 0; //feu
        tab_dégat[2] = 0; //eau
        tab_dégat[3] = 0; //feuille
        tab_dégat[4] = 0; //terre

        switch (arme_equip.getType()) { //dégat élémentaire lié à l'arme
            case "feu" -> tab_dégat[1] = arme_equip.getType_degat();
            case "eau" -> tab_dégat[2] = arme_equip.getType_degat();
            case "feuille" -> tab_dégat[3] = arme_equip.getType_degat();
            case "terre" -> tab_dégat[4] = arme_equip.getType_degat();
        }
        hunter.setNbfleche(hunter.getNbfleche() - 1); //perte de la flèche
        return tab_dégat;
    }

    public static double[] Attaque_au_couteau(Hunter hunter) {
        Random r = new Random();
        int n = r.nextInt(100);

        int damage = 0;
        if (n < hunter.getChance()) {

            damage = 2 * ((hunter.getDegat_base()));
            System.out.println("coup critique");

        } else {
            damage = ((hunter.getDegat_base())); //juste les dégat de base sans dégat d'arme ou dégat élémentaire
        }

        double[] tab_dégat = new double[5];
        tab_dégat[0] = damage;
        tab_dégat[1] = 0; //feu
        tab_dégat[2] = 0; //eau
        tab_dégat[3] = 0; //feuille
        tab_dégat[4] = 0; //terre

        return tab_dégat;
    }

    public static Hero gHunter(Hero[] heros, Weapon[] liste_arme, int i) {
        heros[i] = new Hunter();
        heros[i].setHealth(150);
        heros[i].setChance(50);
        heros[i].setCurrent_health(heros[i].getHealth());
        heros[i].setDegat_base(30);
        heros[i].setDef(20);
        heros[i].setCurrent_def(heros[i].getDef());
        heros[i].setDegat_fond(heros[i].getDegat_base());
        heros[i].setNbfleche(15);
        heros[i].setType("feuille");

        heros[i].initialise_inventory();
        liste_arme[i] = new Weapon();
        liste_arme[i].setBonus_degat(10);
        liste_arme[i].setName("arc d'aventurier");
        liste_arme[i].setType("feuille");
        liste_arme[i].setType_degat(5);
        heros[i].addWeapon(liste_arme[i]);

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
