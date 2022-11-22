package GUI;

import jeu_console.Combattant.Enemy;
import jeu_console.Combattant.Hero.Hero;
import jeu_console.Item.arme_potion.Weapon;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@EqualsAndHashCode
@ToString

@Getter
@Setter

public class Core {
    public int nombre_héros=0;
    public Hero[] listehéros;
    public String[] listeclasse;
    public Weapon[] liste_arme;

    public Enemy[] liste_enemy;

}
