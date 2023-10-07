package forHxH.game.engine;

import static forHxH.game.creatures.Gamer.CREATURE_TYPE_GAMER;
import static forHxH.game.creatures.Monster.CREATURE_TYPE_MONSTER;
import static forHxH.game.utils.Generator.WRONG_CREATURE_TYPE_WARNING;
import forHxH.game.creatures.Creature;
import forHxH.game.creatures.Gamer;
import forHxH.game.creatures.Monster;
import java.util.Scanner;

public class GameSession {
    public static final String GAMER_WIN_TEXT = "Monster is dead! Congratulations!";
    public static final String MONSTER_WIN_TEXT = "Monster is win :(! Try again to fight!";
    public static final String AGAINST_TEXT = " acts against ";
    public static final String GAMER_ROUND_EXPLANATION = "Gamer, are you attack or heal yourself?" +
            " Enter your choice - A/H.";
    public static final String HEAL_RESULT_TEXT = "Gamer healed yourself.";
    public static final String WRONG_TURN_INPUT_ERROR = "Wrong input. Please, input 'A' or 'H' to attack monster" +
            " or heal yourself";
    public static final String HEALTH_STATUS = " current health is now ";
    public static final String HEAL_COUNT_STATUS = " healing casts is now ";
    private String turnOrder;
    private Monster monster;
    private Gamer gamer;

    public GameSession(String turnOrder, Creature[] monsterAndGamer) {
        this.turnOrder = turnOrder;
        this.monster = (Monster) monsterAndGamer[0];
        this.gamer = (Gamer) monsterAndGamer[1];
    }

    public void playGame() {
        while(monster.getCurrentHealth() != 0 || gamer.getCurrentHealth() != 0) {
            makeRound();
        }

        if (gamer.getCurrentHealth() == 0) {
            System.out.println(MONSTER_WIN_TEXT);
        } else {
            System.out.println(GAMER_WIN_TEXT);
        }
        System.exit(0);
    }

    private void makeRound() {
        String attackerName;
        String defenderName;
        int damageInRound = 0;

        System.out.println(CREATURE_TYPE_GAMER + HEALTH_STATUS + gamer.getCurrentHealth());
        System.out.println(CREATURE_TYPE_MONSTER + HEALTH_STATUS + monster.getCurrentHealth());
        System.out.println(CREATURE_TYPE_GAMER + HEAL_COUNT_STATUS + gamer.getHealCount());

        switch(turnOrder) {
            case CREATURE_TYPE_GAMER -> {
                attackerName = CREATURE_TYPE_GAMER;
                defenderName = CREATURE_TYPE_MONSTER;
                damageInRound = gamer.attackAndCalculateDamage(monster);
            }
            case CREATURE_TYPE_MONSTER -> {
                attackerName = CREATURE_TYPE_MONSTER;
                defenderName = CREATURE_TYPE_GAMER;
                damageInRound = monster.attackAndCalculateDamage(gamer);
            }
            default -> throw new RuntimeException(WRONG_CREATURE_TYPE_WARNING);
        }
        System.out.println(attackerName + AGAINST_TEXT + defenderName + "!");

        if (turnOrder.equals(CREATURE_TYPE_GAMER)) {
            System.out.println(GAMER_ROUND_EXPLANATION);

            try(Scanner turnScanner = new Scanner(System.in)) {
                String playerTurnChoice = turnScanner.next();

                switch (playerTurnChoice) {
                    case "A" -> monster.setCurrentHealth(Math.max(monster.getCurrentHealth() - damageInRound, 0));
                    case "H" -> {
                        gamer = gamer.healYourself();
                        System.out.println(HEAL_RESULT_TEXT);
                    }
                    default -> System.out.println(WRONG_TURN_INPUT_ERROR);
                }
            }
        } else {
            gamer.setCurrentHealth(Math.max(gamer.getCurrentHealth() - damageInRound, 0));
        }

        if (turnOrder.equals(CREATURE_TYPE_GAMER)) {
            turnOrder = CREATURE_TYPE_MONSTER;
        } else {
            turnOrder = CREATURE_TYPE_GAMER;
        }
    }
}
