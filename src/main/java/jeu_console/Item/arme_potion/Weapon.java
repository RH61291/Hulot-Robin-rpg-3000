package jeu_console.Item.arme_potion;

import jeu_console.Item.item;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Weapon extends item {
    private int bonus_degat;
    private int bonus_soin;
    private String name;
    private int type_degat;
    private String type;

    public static void main(String[] args) {

    }
}
