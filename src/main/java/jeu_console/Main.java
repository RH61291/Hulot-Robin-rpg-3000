package jeu_console;

import GUI.Gui;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int mode;
        while (true) {

            try {

                System.out.println("graphic (1) or console(2)");
                mode = sc.nextInt();
                if (mode == 1 || mode == 2) {
                    break;
                }
                System.out.println("donner 1 ou 2\n");
            } catch (Exception e) {

                sc.nextLine();
                System.out.println("donner 1 ou 2\n");
            }
        }
        if (mode == 2) {
            System.out.println(" ");
            Game game = new Game();
            Game.playGame();
        }
        if (mode == 1) {
            String[] Args = new String[1];
            Gui gui = new Gui();
            Gui.main(Args);
        }
    }

}
