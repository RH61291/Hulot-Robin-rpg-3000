package jeu_console.Combattant.Hero.cc_distance.sorcier;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;

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
        tab_dégat[1] =0; //feu
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
        tab_dégat[1] =0; //feu
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


}
