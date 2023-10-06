package forHxH.game;

import forHxH.game.engine.GamePreparation;
import java.util.Scanner;

public class App {
    public static final String INTRODUCTION_MESSAGE = "Welcome in the 'Monster battle!'";
    public static final String TURNS_ORDER_QUESTION = "Are you attacking (A) a monster or will you defend" +
            " (D) yourself? WARNING! The monster can win with one hit. I recommend attacking first!" +
            " Enter your choice - A/D.";
    public static final String WRONG_INPUT_ERROR = "Wrong input. Please, input 'A' or 'D' to start game" +
            " or 'Q' to exit.";

    public static void main(String[] args) {
        System.out.println(INTRODUCTION_MESSAGE);
        System.out.println(TURNS_ORDER_QUESTION);

        try(Scanner gameStartScanner = new Scanner(System.in)) {
            String playerTurnOrderChoice = gameStartScanner.next();
            startGame(playerTurnOrderChoice);
        }
    }

    private static void startGame(String playerTurnOrderChoice) {
        switch (playerTurnOrderChoice) {
            case "A" -> GamePreparation.prepareGame("A");
            case "D" -> GamePreparation.prepareGame("D");
            case "Q" -> System.exit(0);
            default -> System.out.println(WRONG_INPUT_ERROR);
        }
    }
}
