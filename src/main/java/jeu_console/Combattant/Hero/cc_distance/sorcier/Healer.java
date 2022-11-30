package jeu_console.Combattant.Hero.cc_distance.sorcier;


import jeu_console.Combattant.Combattant;
import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.conso.Potion;
import jeu_console.Item.arme_potion.consommable;

import java.util.Random;

import static java.lang.Math.round;


public class Healer extends Hero {
    public static void heal(Healer lanceur, Combattant cible) {
        Random r = new Random();
        int n = r.nextInt(100);

        Weapon arme_equip = lanceur.getInventaire_weapon()[lanceur.getWeapon_equipped()]; //récupération de l'arme
        double vie = cible.getCurrent_health(); //la vie de la cible

        if (n < lanceur.getChance()) {
            vie = cible.getCurrent_health() + 2 * (lanceur.getSoin_base() + arme_equip.getBonus_soin()); //def du gain
            System.out.println("soin critique");
            System.out.println(2 * (lanceur.getSoin_base() + arme_equip.getBonus_soin()) + " vie soignée");

        } else {
            vie = cible.getCurrent_health() + (lanceur.getSoin_base() + arme_equip.getBonus_soin());
            System.out.println((lanceur.getSoin_base() + arme_equip.getBonus_soin()) + " vie soignée");
        }

        if (vie > cible.getHealth()) { //si le soin fait dépasser la vie max
            vie = cible.getHealth(); //redéfinition du gain comme le manque
        }
        cible.setCurrent_health(vie);
        lanceur.setCurrent_magie(lanceur.getCurrent_magie() - 2);
    } //méthode de heal

    public static void ressurect(Healer lanceur, Combattant cible) {
        cible.setCurrent_health(round(cible.getHealth() / 3)); //rend 1/3 des pv max à la cible
        lanceur.setCurrent_magie(lanceur.getCurrent_magie() - 4);
    }

    public static void healGR(Healer lanceur, Combattant[] cible) {
        Random r = new Random();
        int n = r.nextInt(100);

        Weapon arme_equip = lanceur.getInventaire_weapon()[lanceur.getWeapon_equipped()];

        for (int i = 0; i < cible.length; i++) { //parcours de la liste des héros

            if (cible[i].getCurrent_health() > 0) { //si héros vivant

                double vie = cible[i].getCurrent_health();
                if (n < lanceur.getChance()) {
                    vie = cible[i].getCurrent_health() + (lanceur.getSoin_base() + arme_equip.getBonus_soin());
                    System.out.println("soin critique");
                    System.out.println((lanceur.getSoin_base() + arme_equip.getBonus_soin()) + " vie soignée");
                } else {
                    vie = cible[i].getCurrent_health() + (lanceur.getSoin_base() + arme_equip.getBonus_soin()) / 2; //soin du héros
                    System.out.println((lanceur.getSoin_base() + arme_equip.getBonus_soin()) + " vie soignée");
                }
                if (vie > cible[i].getHealth()) {
                    vie = cible[i].getHealth();
                }
                cible[i].setCurrent_health(vie);
            }
        }
        lanceur.setCurrent_magie(lanceur.getCurrent_magie() - 3);
    } //heal de groupe

    public static Hero gHealer(Hero[] heros, Weapon[] liste_arme, int i) {
        heros[i] = new Healer();
        heros[i].setHealth(100);
        heros[i].setChance(50);
        heros[i].setCurrent_health(heros[i].getHealth());
        heros[i].setSoin_base(40);
        heros[i].setDef(10);
        heros[i].setCurrent_def(heros[i].getDef());
        heros[i].setDegat_fond(heros[i].getDegat_base());
        heros[i].setMagie(20);
        heros[i].setCurrent_magie(heros[i].getMagie());
        heros[i].setType("eau");

        heros[i].initialise_inventory();
        liste_arme[i] = new Weapon();
        liste_arme[i].setBonus_soin(10);
        liste_arme[i].setName("baton d'aventurier");
        liste_arme[i].setType("eau");
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
