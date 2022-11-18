package jeu_console.Combattant.Hero.cc_distance;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
import java.util.Scanner;

@Getter
@Setter
@EqualsAndHashCode
@ToString

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

}
