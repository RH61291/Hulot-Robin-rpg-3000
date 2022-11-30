package jeu_console.Item.arme_potion.conso;


import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.consommable;

import java.util.Scanner;


public class Food extends consommable {

    private static final Scanner sc = new Scanner(System.in);

    public static void manger(Hero hero) {
        consommable[] listeConso = hero.getInventaire_consumable(); //récupération liste consommable

        int choix = 0; //initialisation des variables
        int compteur = 0;
        int var = 0;

        while (true) {
            try {
                compteur = 0;
                System.out.println("choisissez votre nourriture");

                for (int i = 0; i < listeConso.length; i++) { //parcours liste consommable

                    if (listeConso[i].getName() == null) { //si l'élément est vide

                    } else {

                        if (listeConso[i].getClasse().equals("Food")) { //si sa classe est food

                            System.out.println(listeConso[i].getName() + "(" + i + ") qui rend " + listeConso[i].getSoin() + " pv");
                            compteur += 1; //compteur de nourriture
                        }
                    }
                }

                choix = sc.nextInt();

                int[] liste_choix = new int[compteur]; //liste de nouritture
                int var2 = 0; //servira pour remplir la liste de nouritture

                for (int i = 0; i < listeConso.length; i++) {

                    if (listeConso[i].getName() == null) {

                    } else {

                        if (listeConso[i].getClasse().equals("Food")) {

                            liste_choix[var2] = i; //son index dans la liste des consommbale est ajouté dans la listed des nourriture
                            var2 += 1;
                        }
                    }
                }//son index dans la liste des consommbale est ajouté dans la liste de nourriture

                int var3 = 0;

                for (int i = 0; i < liste_choix.length; i++) {

                    if (liste_choix[i] == choix) {

                        var3 += 1;
                    }
                } //si notre choix correspond à un indice d'une nourriture

                if (var3 == 0) {

                    System.out.println("mauvais chiffre");
                } //si choix ne correspond à rien

                else {

                    break;
                } //si choix correspond on sort de la boucle

            } catch (Exception e) {

                sc.nextLine();
                System.out.println("donner un chiffre");
            } //gestion des erreurs
        }//choix dans l'inventaire


        if ((hero.getCurrent_health() + listeConso[choix].getSoin()) > hero.getHealth()) {

            System.out.println("le héro a regagné " + (hero.getHealth() - hero.getCurrent_health()) + " pv");
            hero.setCurrent_health(hero.getHealth());
        } //si la vie regagné dépassse les pv max

        else {

            hero.setCurrent_health(hero.getCurrent_health() + listeConso[choix].getSoin());
            System.out.println("le héro a regagné " + (listeConso[choix].getSoin()) + " pv");
        }

        hero.suppConsumable(listeConso[choix]); //suppression de la nouriture utilisée
    } //méthode pour utiliser un consommable de classe food

}
