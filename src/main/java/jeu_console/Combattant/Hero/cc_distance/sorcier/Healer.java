package jeu_console.Combattant.Hero.cc_distance.sorcier;


import jeu_console.Combattant.Combattant;
import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
@ToString

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
        cible.setCurrent_health(cible.getHealth() / 3); //rend 1/3 des pv max à la cible
        lanceur.setCurrent_magie(lanceur.getCurrent_magie() - 4);
    }

    public static void healGR(Healer lanceur, Combattant[] cible) {
        Random r = new Random();
        int n = r.nextInt(100);

        Weapon arme_equip = lanceur.getInventaire_weapon()[lanceur.getWeapon_equipped()];

        for (int i = 0; i < cible.length ; i++) { //parcours de la liste des héros

            if(cible[i].getCurrent_health()>0){ //si héros vivant

                double vie = cible[i].getCurrent_health();
                if (n < lanceur.getChance()) {
                    vie = cible[i].getCurrent_health() +  (lanceur.getSoin_base() + arme_equip.getBonus_soin());
                    System.out.println("soin critique");
                    System.out.println((lanceur.getSoin_base() + arme_equip.getBonus_soin()) + " vie soignée");
                } else {
                    vie = cible[i].getCurrent_health() + (lanceur.getSoin_base() + arme_equip.getBonus_soin())/2; //soin du héros
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
}
