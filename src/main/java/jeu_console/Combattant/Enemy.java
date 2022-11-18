package jeu_console.Combattant;

import java.util.Random;

public class Enemy extends Combattant {

    private int level;


    public static Enemy genEnemy(int level) {
        Enemy création = new Enemy(); //nouvel ennemi
        Random r = new Random();

        int n = 50 + r.nextInt(50) +level*5;//la vie
        création.setHealth(n);
        création.setCurrent_health(création.getHealth());

        int n2 = 15 + r.nextInt(15)+5*level; //les dégats de base
        création.setDegat_base(n2);

        int n3 = 5 + r.nextInt(10)+5*level; //la défense
        création.setDef(n3);

        int n4 = r.nextInt(3);// son type
        switch (n4) {

            case 0 -> création.setType("feu");
            case 1 -> création.setType("feuille");
            case 2 -> création.setType("eau");
            case 3 -> création.setType("terre");

        }

        return création;
    } //création avec variable bornée des ennemis

    public static double[] charge(Enemy lanceur) {

        double[] tab_dégat = new double[5];

        tab_dégat[0] = lanceur.getDegat_base();//dégat de base
        tab_dégat[1] = 0;
        tab_dégat[2] = 0;
        tab_dégat[3] = 0;
        tab_dégat[4] = 0;

        switch (lanceur.getType()) { //récupération type, attaque élémentaire correspondant à la moitié des dégats bruts

            case "feu" -> tab_dégat[1] = (double) lanceur.getDegat_base() / 2;
            case "eau" -> tab_dégat[2] = (double) lanceur.getDegat_base() / 2;
            case "feuille" -> tab_dégat[3] = (double) lanceur.getDegat_base() / 2;
            case "terre" -> tab_dégat[4] = (double) lanceur.getDegat_base() / 2;
        }

        return tab_dégat;
    } //méthode d'attaque des ennemis

    public static Enemy genBoss() {
        Enemy création = new Enemy();

        Random r = new Random();
        création.setHealth(600); //vie fixe
        création.setCurrent_health(création.getHealth());

        int n2 = 40 + r.nextInt(35);
        création.setDegat_base(n2);

        int n3 = 20 + r.nextInt(20);
        création.setDef(n3);

        int n4 = r.nextInt(3);
        switch (n4) {

            case 0 -> création.setType("feu");
            case 1 -> création.setType("feuille");
            case 2 -> création.setType("eau");
            case 3 -> création.setType("terre");
        }


        return création;
    } //création boss avec stats bornée
}
