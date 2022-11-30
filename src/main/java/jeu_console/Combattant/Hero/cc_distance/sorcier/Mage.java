package jeu_console.Combattant.Hero.cc_distance.sorcier;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.conso.Potion;
import jeu_console.Item.arme_potion.consommable;

import java.util.Random;


public class Mage extends Hero {

    // ces quatre méthodes sont les même seul les type de dégat sont différents
    public static double[] bouleDeFeu(Mage mage) {
        Random r = new Random();
        int n = r.nextInt(100);

        int damage = 0;
        Weapon arme_equip = mage.getInventaire_weapon()[mage.getWeapon_equipped()]; //récupère l'arme

        if (n < mage.getChance()) {
            damage = 2 * (mage.getDegat_base() + arme_equip.getBonus_degat()); //si critique
            System.out.println("coup critique");
        } else {
            damage = (mage.getDegat_base() + arme_equip.getBonus_degat()); //degat de base + degat de l'arme
        }

        double[] tab_dégat = new double[5]; //degat purement élémentaire
        tab_dégat[0] = 0;
        tab_dégat[1] = damage; //feu
        tab_dégat[2] = 0; //eau
        tab_dégat[3] = 0; //feuille
        tab_dégat[4] = 0; //terre

        switch (arme_equip.getType()) { //ajout des dégats de type de l'arme
            case "feu" -> tab_dégat[1] += arme_equip.getType_degat();
            case "eau" -> tab_dégat[2] += arme_equip.getType_degat();
            case "feuille" -> tab_dégat[3] += arme_equip.getType_degat();
            case "terre" -> tab_dégat[4] += arme_equip.getType_degat();
        }
        mage.setCurrent_magie(mage.getCurrent_magie() - 2);
        return tab_dégat;
    }

    public static double[] lameDeau(Mage mage) {
        Random r = new Random();
        int n = r.nextInt(100);
        int damage = 0;
        Weapon arme_equip = mage.getInventaire_weapon()[mage.getWeapon_equipped()];
        if (n < mage.getChance()) {
            damage = 2 * (mage.getDegat_base() + arme_equip.getBonus_degat());
            System.out.println("coup critique");
        } else {
            damage = (mage.getDegat_base() + arme_equip.getBonus_degat());
        }

        double[] tab_dégat = new double[5];
        tab_dégat[0] = 0;
        tab_dégat[1] = 0; //feu
        tab_dégat[2] = damage; //eau
        tab_dégat[3] = 0; //feuille
        tab_dégat[4] = 0; //terre

        switch (arme_equip.getType()) {
            case "feu" -> tab_dégat[1] += arme_equip.getType_degat();
            case "eau" -> tab_dégat[2] += arme_equip.getType_degat();
            case "feuille" -> tab_dégat[3] += arme_equip.getType_degat();
            case "terre" -> tab_dégat[4] += arme_equip.getType_degat();
        }
        mage.setCurrent_magie(mage.getCurrent_magie() - 2);
        return tab_dégat;
    }

    public static double[] séisme(Mage mage) {
        Random r = new Random();
        int n = r.nextInt(100);
        int damage = 0;
        Weapon arme_equip = mage.getInventaire_weapon()[mage.getWeapon_equipped()];
        if (n < mage.getChance()) {
            damage = 2 * (mage.getDegat_base() + arme_equip.getBonus_degat());
            System.out.println("coup critique");
        } else {
            damage = (mage.getDegat_base() + arme_equip.getBonus_degat());
        }

        double[] tab_dégat = new double[5];
        tab_dégat[0] = 0;
        tab_dégat[1] = 0; //feu
        tab_dégat[2] = 0; //eau
        tab_dégat[3] = 0; //feuille
        tab_dégat[4] = damage; //terre

        switch (arme_equip.getType()) {
            case "feu" -> tab_dégat[1] += arme_equip.getType_degat();
            case "eau" -> tab_dégat[2] += arme_equip.getType_degat();
            case "feuille" -> tab_dégat[3] += arme_equip.getType_degat();
            case "terre" -> tab_dégat[4] += arme_equip.getType_degat();
        }
        mage.setCurrent_magie(mage.getCurrent_magie() - 2);
        return tab_dégat;
    }

    public static double[] feuilleLame(Mage mage) {
        Random r = new Random();
        int n = r.nextInt(100);
        int damage = 0;
        Weapon arme_equip = mage.getInventaire_weapon()[mage.getWeapon_equipped()];
        if (n < mage.getChance()) {
            damage = 2 * (mage.getDegat_base() + arme_equip.getBonus_degat());
            System.out.println("coup critique");
        } else {
            damage = (mage.getDegat_base() + arme_equip.getBonus_degat());
        }

        double[] tab_dégat = new double[5];
        tab_dégat[0] = 0;
        tab_dégat[1] = 0; //feu
        tab_dégat[2] = 0; //eau
        tab_dégat[3] = damage; //feuille
        tab_dégat[4] = 0; //terre

        switch (arme_equip.getType()) {
            case "feu" -> tab_dégat[1] += arme_equip.getType_degat();
            case "eau" -> tab_dégat[2] += arme_equip.getType_degat();
            case "feuille" -> tab_dégat[3] += arme_equip.getType_degat();
            case "terre" -> tab_dégat[4] += arme_equip.getType_degat();
        }
        mage.setCurrent_magie(mage.getCurrent_magie() - 2);
        return tab_dégat;
    }

    public static Hero gMage(Hero[] heros, Weapon[] liste_arme, int i) {
        heros[i] = new Mage();
        heros[i].setHealth(100);
        heros[i].setChance(20);
        heros[i].setCurrent_health(heros[i].getHealth());
        heros[i].setDegat_base(10);
        heros[i].setDef(10);
        heros[i].setCurrent_def(heros[i].getDef());
        heros[i].setDegat_fond(heros[i].getDegat_base());
        heros[i].setMagie(14);
        heros[i].setCurrent_magie(heros[i].getMagie());
        heros[i].setType("feu");

        heros[i].initialise_inventory();
        liste_arme[i] = new Weapon();
        liste_arme[i].setBonus_degat(10);
        liste_arme[i].setName("grimoire");
        liste_arme[i].setType("feu");
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
        potion1.setMana(10);
        potion1.setClasse("Potion");
        potion1.setName("potion de mana");

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
