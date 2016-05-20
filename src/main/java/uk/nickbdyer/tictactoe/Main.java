package uk.nickbdyer.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CLI ui = new CLI(new Scanner(System.in), System.out);
        new GameEngine().start(ui);
    }
}
