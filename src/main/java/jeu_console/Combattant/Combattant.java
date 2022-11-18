package jeu_console.Combattant;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static java.lang.Math.round;

@EqualsAndHashCode
@ToString

@Getter
@Setter

public class Combattant {

    private double health;
    private double current_health;
    private int degat_fond;
    private int degat_base;
    private int soin_base;
    private int def;
    private int current_def;
    private Integer nbfleche;
    private int magie;
    private int current_magie;
    private String type;
    private int chance;

    public static void receiveDamage(double[] tab_degat, Combattant cible) {
        double receiveDamage = 0;
        receiveDamage += tab_degat[0] * (double) (100 - cible.getCurrent_def()) / 100; //base de dégat pur qui sont affecté par la défense

        if (cible.getType().equals("feu")) {

            receiveDamage += tab_degat[1] * 1; //faiblesse et résistance en fonction des dégat élémentaire
            receiveDamage += tab_degat[2] * 1.5;
            receiveDamage += tab_degat[3] * 0.5;
            receiveDamage += tab_degat[4] * 1;
        }

        if (cible.getType().equals("feuille")) {

            receiveDamage += tab_degat[1] * 1.5;
            receiveDamage += tab_degat[2] * 1;
            receiveDamage += tab_degat[3] * 1;
            receiveDamage += tab_degat[4] * 0.5;
        }

        if (cible.getType().equals("eau")) {

            receiveDamage += tab_degat[1] * 0.5;
            receiveDamage += tab_degat[2] * 1;
            receiveDamage += tab_degat[3] * 1;
            receiveDamage += tab_degat[4] * 1.5;
        }

        if (cible.getType().equals("terre")) {

            receiveDamage += tab_degat[1] * 1;
            receiveDamage += tab_degat[2] * 0.5;
            receiveDamage += tab_degat[3] * 1.5;
            receiveDamage += tab_degat[4] * 1;

        }
        System.out.println(round(receiveDamage) + " dégats infligés ");
        cible.setCurrent_health(round(cible.getCurrent_health() - receiveDamage));
    } //méthode pour recevoire des dégats


}
