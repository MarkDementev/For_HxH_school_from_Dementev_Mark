package forHxH.game.engine;

import forHxH.game.creatures.Creature;
import forHxH.game.creatures.Gamer;
import forHxH.game.creatures.Monster;

import java.util.Scanner;

public class Engine {
    public static void startGame(String turnOrders, Creature[] monsterAndGamer) {
        Monster monster = (Monster) monsterAndGamer[0];
        Gamer gamer = (Gamer) monsterAndGamer[1];

        try(Scanner turnsScanner = new Scanner(System.in)) {
            while(monster.getCurrentHealth() != 0 || gamer.getCurrentHealth() != 0) {

            }
//            String playerTurnOrderChoice = playerInteractionScanner.next();
//            startGame(playerTurnOrderChoice);
        }
    }
}
