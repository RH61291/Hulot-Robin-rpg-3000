package jeu_console.Combattant.Hero;


import jeu_console.Combattant.Combattant;
import jeu_console.Item.arme_potion.Weapon;
import jeu_console.Item.arme_potion.consommable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Hero extends Combattant {

    private Weapon[] inventaire_weapon;
    private int weapon_equipped;
    private consommable[] inventaire_consumable;

    public void initialise_inventory() {

        this.inventaire_weapon = new Weapon[1];
        this.inventaire_consumable = new consommable[10];

        for (int i = 0; i < this.inventaire_weapon.length; i++) {

            this.inventaire_weapon[i] = new Weapon(); //remplissage de l'array
        }

        for (int i = 0; i < this.inventaire_consumable.length; i++) {

            this.inventaire_consumable[i] = new consommable();
        }

    } //création array et remplissage de ses éléments par élément vide

    public void addWeapon(Weapon weapon) {

        for (int i = 0; i < this.inventaire_weapon.length; i++) {

            if (this.inventaire_weapon[i].getName() == null) {

                this.inventaire_weapon[i] = weapon; //si la place est occupé par un élément vide
                break;
            }

            if (i == this.inventaire_weapon.length) {

                System.out.println("inventaire d'arme plein");
            }
        }
    }


    public void addConsumable(consommable consommable) {

        for (int i = 0; i < this.inventaire_consumable.length; i++) {

            if (this.inventaire_consumable[i].getName() == null) {

                this.inventaire_consumable[i] = consommable;
                break;
            }
            if (i == this.inventaire_consumable.length - 1) {

                System.out.println("inventaire d'armure plein");
            }
        }
    }

    public void suppConsumable(consommable consommable) {

        for (int i = 0; i < this.inventaire_consumable.length; i++) {

            if (consommable.getName() == null) {

                System.out.println("vous n'avez pas de consommable ici");
                break;
            }

            if (Objects.equals(this.inventaire_consumable[i].getName(), consommable.getName())) {

                this.inventaire_consumable[i] = new consommable();
            }
        }
    }

    public void equipWeapon(Weapon weapon) {
        for (int i = 0; i < this.inventaire_weapon.length; i++) {
            if (weapon.getName().equals(this.inventaire_weapon[i].getName())) {
                this.weapon_equipped = i;
            }
        }
    } //si l'invnetaire d'arme permet plus de une arme

}


