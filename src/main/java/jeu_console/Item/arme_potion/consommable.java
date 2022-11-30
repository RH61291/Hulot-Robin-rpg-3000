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

public class consommable extends item {
    public Integer soin;
    private Integer bonus_degat;
    private Integer bonus_def;
    private String name;
    private String classe;
    private Integer mana;

    public static void main(String[] args) {

    }

}
