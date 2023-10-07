package forHxH.game;

import static forHxH.game.creatures.Gamer.CREATURE_TYPE_GAMER;
import static forHxH.game.creatures.Monster.CREATURE_TYPE_MONSTER;
import forHxH.game.engine.GamePreparation;
import java.util.Scanner;

public class App {
    public static final String INTRODUCTION_MESSAGE = "Welcome in the 'Monster battle!'";
    public static final String TURNS_ORDER_QUESTION = "Are you attacking (A) a monster or will you defend" +
            " (D) yourself? WARNING! The monster can win with one hit. I recommend attacking first!" +
            " Enter your choice - A/D.";
    public static final String BYE_MESSAGE = "Goodbye!";
    public static final String WRONG_START_INPUT_ERROR = "Wrong input. Please, input 'A' or 'D' to start game" +
            " or 'Q' to exit.";

    public static void main(String[] args) {
        System.out.println(INTRODUCTION_MESSAGE);
        System.out.println(TURNS_ORDER_QUESTION);
        startGame();
    }

    private static void startGame() {
        Scanner gameStartScanner = new Scanner(System.in);
        String playerTurnOrderChoice = gameStartScanner.next();

        switch (playerTurnOrderChoice) {
            case "A" -> GamePreparation.prepareGame(CREATURE_TYPE_GAMER);
            case "D" -> GamePreparation.prepareGame(CREATURE_TYPE_MONSTER);
            case "Q" -> {
                System.out.println(BYE_MESSAGE);
                gameStartScanner.close();
                System.exit(0);
            }
            default -> {
                System.out.println(WRONG_START_INPUT_ERROR);
                startGame();
            }
        }
    }
}
