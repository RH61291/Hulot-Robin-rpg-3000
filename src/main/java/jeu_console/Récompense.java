package jeu_console;

import jeu_console.Combattant.Hero.Hero;
import jeu_console.Combattant.Hero.cc_distance.Hunter;
import jeu_console.Combattant.Hero.cc_distance.Warrior;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Healer;
import jeu_console.Combattant.Hero.cc_distance.sorcier.Mage;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.conso.Potion;
import jeu_console.Item.arme_potion.consommable;

import java.util.Scanner;

public class Récompense {

    private static final Scanner sc = new Scanner(System.in);

    public static void recompense(Hero hero, String classe, int combat_remporté) {
        System.out.println("----------------------------");
        int choix = 0;

        switch (combat_remporté) { //en fonction du nombre de combat remporté

            case 1 -> {

                while (true) {

                    System.out.println("Voici vos recompenses pour le combat " + combat_remporté + ", veuillez en choisir une (numéro):");
                    try {

                        System.out.println("(1) vous gagnez de la nourriture exquise (25 de pv) ");
                        System.out.println("(2) votre cueillez une trèfle à quatre feuille (+10 de chance) ");
                        System.out.println("(3) vous récupérez une potion de votre choix ");

                        if (classe.equals("Warrior")) {

                            System.out.println("(4) vous trouvez une armure (+10 de def) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Hunter")) {

                            System.out.println("(4) vous trouvez une armure (+10 de def) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Mage")) {

                            System.out.println("(4) vous augnmentez votre mana (+10 de mana) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Healer")) {

                            System.out.println("(4) vous augmentez votre mana (+10 de mana) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        System.out.println("(6) vous vous reposez paisiblement (+10 pv max) ");

                        choix = sc.nextInt();
                        if (choix == 1) {

                            recGE3(hero);
                            break;
                        }
                        if (choix == 2) {

                            recGE4(hero);
                            break;
                        }
                        if (choix == 3) {

                            recGE2(hero);
                            break;
                        }
                        if (choix == 4 && (classe.equals("Warrior") || classe.equals("Hunter"))) {

                            recGE(hero);
                            break;
                        }
                        if (choix == 4 && (classe.equals("Mage") || classe.equals("Healer"))) {

                            recGE5(hero);
                            break;
                        }
                        if (choix == 5) {

                            if (classe.equals("Warrior")) {

                                recWA1((Warrior) hero);
                            }
                            if (classe.equals("Hunter")) {

                                recHU1((Hunter) hero);
                            }
                            if (classe.equals("Mage")) {

                                recMA1((Mage) hero);
                            }
                            if (classe.equals("Healer")) {

                                recHE1((Healer) hero);
                            }
                            break;
                        }
                        if (choix == 6) {

                            recGE6(hero);
                            break;
                        } else {

                            sc.nextLine();
                            System.out.println("mauvais chiffre\n");
                        }
                    } catch (Exception e) {

                        sc.nextLine();
                        System.out.println("donner un des chiffres disponibles\n");
                    }
                }
            }
            case 2 -> {

                while (true) {

                    System.out.println("Voici vos recompenses, veuillez en choisir une (numéro):");
                    try {

                        System.out.println("(1) vous gagnez de la nourriture exquise (25 de pv) ");
                        System.out.println("(2) votre chance augmente (+10 de chance) ");
                        System.out.println("(3) vous récupérez une potion de votre choix ");

                        if (classe.equals("Warrior")) {

                            System.out.println("(4) vous trouvez une armure (+10 de def) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Hunter")) {

                            System.out.println("(4) vous trouvez une armure (+10 de def) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Mage")) {

                            System.out.println("(4) vous augnmentez votre mana (+10 de mana) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Healer")) {

                            System.out.println("(4) vous augmentez votre mana (+10 de mana) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        System.out.println("(6) vous vous reposez paisiblement (+10 pv max) ");

                        choix = sc.nextInt();
                        if (choix == 1) {

                            recGE3(hero);
                            break;
                        }
                        if (choix == 2) {

                            recGE4(hero);
                            break;
                        }
                        if (choix == 3) {

                            recGE2(hero);
                            break;
                        }
                        if (choix == 4 && (classe.equals("Warrior") || classe.equals("Hunter"))) {

                            recGE(hero);
                            break;
                        }
                        if (choix == 4 && (classe.equals("Mage") || classe.equals("Healer"))) {

                            recGE5(hero);
                            break;
                        }
                        if (choix == 5) {

                            if (classe.equals("Warrior")) {

                                recWA2((Warrior) hero);
                            }
                            if (classe.equals("Hunter")) {

                                recHU2((Hunter) hero);
                            }
                            if (classe.equals("Mage")) {

                                recMA2((Mage) hero);
                            }
                            if (classe.equals("Healer")) {

                                recHE2((Healer) hero);
                            }
                            break;
                        }
                        if (choix == 6) {

                            recGE6(hero);
                            break;
                        } else {

                            sc.nextLine();
                            System.out.println("mauvais chiffre\n");
                        }
                    } catch (Exception e) {

                        sc.nextLine();
                        System.out.println("donner un des chiffres disponibles\n");
                    }
                }
            }
            case 3 -> {

                while (true) {

                    System.out.println("Voici vos recompenses, veuillez en choisir une (numéro):");
                    try {

                        System.out.println("(1) vous gagnez de la nourriture exquise (50 de pv) ");
                        System.out.println("(2) votre chance augmente (+10 de chance) ");
                        System.out.println("(3) vous récupérez une potion de votre choix ");

                        if (classe.equals("Warrior")) {

                            System.out.println("(4) vous trouvez une armure (+10 de def) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Hunter")) {

                            System.out.println("(4) vous trouvez une armure (+10 de def) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Mage")) {

                            System.out.println("(4) vous augnmentez votre mana (+10 de mana) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        if (classe.equals("Healer")) {

                            System.out.println("(4) vous augmentez votre mana (+10 de mana) ");
                            System.out.println("(5) vous trouvez une nouvelle arme tier " + combat_remporté);
                        }
                        System.out.println("(6) vous vous reposez paisiblement (+10 pv max) ");

                        choix = sc.nextInt();
                        if (choix == 1) {

                            recGE3(hero);
                            break;
                        }
                        if (choix == 2) {

                            recGE4(hero);
                            break;
                        }
                        if (choix == 3) {

                            recGE2(hero);
                            break;
                        }
                        if (choix == 4 && (classe.equals("Warrior") || classe.equals("Hunter"))) {

                            recGE(hero);
                            break;
                        }
                        if (choix == 4 && (classe.equals("Mage") || classe.equals("Healer"))) {

                            recGE5(hero);
                            break;
                        }
                        if (choix == 5) {

                            if (classe.equals("Warrior")) {

                                recWA3((Warrior) hero);
                            }
                            if (classe.equals("Hunter")) {

                                recHU3((Hunter) hero);
                            }
                            if (classe.equals("Mage")) {

                                recMA3((Mage) hero);
                            }
                            if (classe.equals("Healer")) {

                                recHE3((Healer) hero);
                            }
                            break;
                        }
                        if (choix == 6) {

                            recGE6(hero);
                            break;
                        } else {

                            sc.nextLine();
                            System.out.println("mauvais chiffre\n");
                        }
                    } catch (Exception e) {

                        sc.nextLine();
                        System.out.println("donner un des chiffres disponibles\n");
                    }
                }
            }
            case 4 -> {

                System.out.println("reposez vous, vous regagnez tout vos pv et mana");
                hero.setCurrent_health(hero.getHealth());
                hero.setCurrent_magie((hero.getMagie()));
            }
        }
        System.out.println("----------------------------");
    } //récompense par héro en fonction du combat efféctué


    //récompense générale

    public static void recGE(Hero hero) {
        System.out.println("votre défense passe de " + hero.getDef() + " à " + (hero.getDef() + 10));
        hero.setDef(hero.getDef() + 10);
        hero.setCurrent_def(hero.getDef());
    } //augmentation défense

    public static void recGE2(Hero hero) {
        while (true) {
            try {
                System.out.println("quelle potion voulez vous prendre: \npotion de vie, potion de dégat, potion de mana, potion d'armure");
                String choix = "";
                choix = sc.nextLine();
                if (choix.equals("potion de vie") || choix.equals("potion de dégat") || choix.equals("potion de mana") || choix.equals("potion d'armure'")) {
                    if (choix.equals("potion de vie")) {
                        Potion potion = new Potion();
                        potion.setSoin(50);
                        potion.setClasse("Potion");
                        potion.setName("potion de vie");
                        hero.addConsumable(potion);
                        break;
                    }
                    if (choix.equals("potion de dégat")) {
                        Potion potion = new Potion();
                        potion.setBonus_degat(10);
                        potion.setClasse("Potion");
                        potion.setName("potion de dégat");
                        hero.addConsumable(potion);
                        break;
                    }
                    if (choix.equals("potion de mana")) {
                        Potion potion = new Potion();
                        potion.setMana(10);
                        potion.setClasse("Potion");
                        potion.setName("potion de mana");
                        hero.addConsumable(potion);
                        break;
                    }
                    if (choix.equals("potion d'armure")) {
                        Potion potion = new Potion();
                        potion.setBonus_def(10);
                        potion.setClasse("Potion");
                        potion.setName("potion d'armure");
                        hero.addConsumable(potion);
                        break;
                    }
                } else {
                    System.out.println("Mauvaise potion indiqué (nom)");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("veuillez donner le nom d'une potion");
            }
        }
    }// donne une potion

    public static void recGE3(Hero hero) {
        consommable food = new consommable();
        food.setClasse("Food");
        food.setName("repas fait maison");
        food.setSoin(50);
        hero.addConsumable(food);
    }//donne de la nourriture

    public static void recGE4(Hero hero) {
        System.out.println("votre chance passe de " + hero.getChance() + " à " + (hero.getChance() + 10));
        hero.setChance(hero.getChance() + 10);
    }//donne de la chance

    public static void recGE5(Hero hero) {
        System.out.println("votre magie passe de " + hero.getMagie() + " à " + (hero.getMagie() + 10));
        hero.setMagie(hero.getMagie() + 10);
    }//donne du mana max

    public static void recGE6(Hero hero) {
        System.out.println("votre vie max passe de " + hero.getHealth() + " à " + (hero.getHealth() + 10));
        hero.setHealth(hero.getHealth() + 10);
    }//donne des pv max


    //récompense par classe
    public static void recWA1(Warrior hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(15);
        arme_equip.setName("Épé de bonne facture");
        arme_equip.setType("feuille");
        arme_equip.setType_degat(10);
        hero.addWeapon(arme_equip);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    } //arme t1

    public static void recWA2(Warrior hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(20);
        arme_equip.setName("Épé royale");
        arme_equip.setType("eau");
        arme_equip.setType_degat(15);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    } //t2

    public static void recWA3(Warrior hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(25);
        arme_equip.setName("Excalibur");
        arme_equip.setType("feu");
        arme_equip.setType_degat(20);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    } //t3


    public static void recMA1(Mage hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(15);
        arme_equip.setName("Grimoire poussièreux");
        arme_equip.setType("feuille");
        arme_equip.setType_degat(10);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    }

    public static void recMA2(Mage hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(20);
        arme_equip.setName("Grimoire oublié");
        arme_equip.setType("eau");
        arme_equip.setType_degat(15);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    }

    public static void recMA3(Mage hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(25);
        arme_equip.setName("Necronomicon");
        arme_equip.setType("terre");
        arme_equip.setType_degat(20);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    }


    public static void recHU1(Hunter hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(15);
        arme_equip.setName("Arc de bonne facture");
        arme_equip.setType("feu");
        arme_equip.setType_degat(10);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    }

    public static void recHU2(Hunter hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(20);
        arme_equip.setName("Arc elfique");
        arme_equip.setType("terrre");
        arme_equip.setType_degat(15);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    }

    public static void recHU3(Hunter hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_degat(15);
        arme_equip.setName("Arc de Pâris");
        arme_equip.setType("eau");
        arme_equip.setType_degat(20);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_degat() + " de dégat et faisant "
                + arme_equip.getType_degat() + " dégat de type " + arme_equip.getType());
    }


    public static void recHE1(Healer hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_soin(15);
        arme_equip.setName("Baton de cerisié");
        arme_equip.setType("terre");
        arme_equip.setType_degat(10);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_soin() + " de soin bonus");
    }

    public static void recHE2(Healer hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_soin(20);
        arme_equip.setName("Baton béni par un saint");
        arme_equip.setType("feu");
        arme_equip.setType_degat(15);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_soin() + " de soin bonus");
    }

    public static void recHE3(Healer hero) {
        Weapon arme_equip = hero.getInventaire_weapon()[hero.getWeapon_equipped()];
        arme_equip.setBonus_soin(25);
        arme_equip.setName("Crosse papal avec une pomme d'éden");
        arme_equip.setType("feuille");
        arme_equip.setType_degat(20);
        System.out.println("vous gagnez " + arme_equip.getName() + " qui fait " + arme_equip.getBonus_soin() + " de soin bonus");
    }

}
