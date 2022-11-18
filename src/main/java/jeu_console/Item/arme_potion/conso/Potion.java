package jeu_console.Item.arme_potion.conso;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.consommable;

import java.util.Scanner;

public class Potion extends consommable {

    private static final Scanner sc = new Scanner(System.in);

    public static void BoireUnePotion(Hero hero) {
        consommable[] listeConso = hero.getInventaire_consumable(); //récupération de l'inventaire de consommable
        String choix1 = "";

        while (true) {

            System.out.println("que voulez vous boire");

            try {

                for (int i = 0; i < listeConso.length; i++) {

                    if (listeConso[i].getName() == null) { //si emplacemnet vide

                    }
                    else {

                        if (listeConso[i].getClasse().equals("Potion")) { //si de classe potion

                            if (listeConso[i].getSoin() != null) {

                                System.out.println(listeConso[i].getName() + " qui rend " + listeConso[i].getSoin() + " pv");
                            } //si la potion rend de la vie

                            if (listeConso[i].getBonus_def() != null) {

                                System.out.println(listeConso[i].getName() + " qui donne " + listeConso[i].getBonus_def() + " armure");
                            } //si elle donne de la défense

                            if (listeConso[i].getBonus_degat() != null) {

                                System.out.println(listeConso[i].getName() + " qui donne " + listeConso[i].getBonus_degat() + " dégats bonus");
                            } //si elle fait des dégat bonus

                            if (listeConso[i].getMana() != null) {

                                System.out.println(listeConso[i].getName() + " qui rend " + listeConso[i].getMana() + " magie");
                            } //si ele rend du mana
                        }
                    }
                }//parcours liste consommable

                choix1 = sc.nextLine();
                if (choix1.equals("potion de vie") || choix1.equals("potion de dégat") || choix1.equals("potion de mana") || choix1.equals("potion d'armure")) {

                    break; //si le choix correspond
                }

                else {

                    System.out.println("Mauvais nom");
                }

            }
            catch (Exception e) {

                sc.nextLine();
                System.out.println("donner une chaine de caractères");
            }//gestion des exceptions
        }//récupération du choix

        int index = 0;

        if (choix1.equals("potion de vie")) {

            for (int i = 0; i < listeConso.length; i++) {

                if (listeConso[i].getName() == null) {

                }
                else {

                    if (listeConso[i].getName().equals("potion de vie")) {

                        index = i;
                    }
                }
            }

            if ((hero.getCurrent_health() + listeConso[index].getSoin()) > hero.getHealth()) {

                System.out.println("le héro a regagné " + (hero.getHealth() - hero.getCurrent_health()) + " pv");
                hero.setCurrent_health(hero.getHealth());
            }
            else {

                hero.setCurrent_health(hero.getCurrent_health() + listeConso[index].getSoin());
                System.out.println("le héro a regagné " + (listeConso[index].getSoin()) + " pv");
            }
        } //fait l'effet de la potion et la retrouve dans l'inventaire des consomable

        if (choix1.equals("potion de mana")) {

            for (int i = 0; i < listeConso.length; i++) {

                if (listeConso[i].getName() == null) {

                }
                else {

                    if (listeConso[i].getName().equals("potion de mana")) {
                        index = i;
                    }
                }
            }

            if ((hero.getCurrent_magie() + listeConso[index].getMana()) > hero.getMagie()) {

                System.out.println("le héro a regagné " + (hero.getMagie() - hero.getCurrent_magie()) + " mana");
                hero.setCurrent_magie(hero.getMagie());
            }
            else {

                hero.setCurrent_magie(hero.getCurrent_magie() + listeConso[index].getMana());
                System.out.println("le héro a regagné " + (listeConso[index].getMana()) + " mana");
            }
        }

        if (choix1.equals("potion d'armure")) {

            for (int i = 0; i < listeConso.length; i++) {

                if (listeConso[i].getName() == null) {

                }
                else {

                    if (listeConso[i].getName().equals("potion d'armure")) {

                        index = i;
                    }
                }
            }

            hero.setCurrent_def(hero.getCurrent_def() + listeConso[index].getBonus_def());
            System.out.println("le héro a gagné " + (listeConso[index].getBonus_def()) + " d'armure");
        }

        if (choix1.equals("potion de dégat")) {

            for (int i = 0; i < listeConso.length; i++) {

                if (listeConso[i].getName() == null) {

                }
                else {

                    if (listeConso[i].getName().equals("potion de dégat")) {

                        index = i;
                    }
                }
            }

            hero.setDegat_base(hero.getDegat_fond() + listeConso[index].getBonus_degat());
            System.out.println("le héro a gagné " + (listeConso[index].getBonus_degat()) + " de dégat");

        }

        hero.suppConsumable(listeConso[index]);
    }
}
