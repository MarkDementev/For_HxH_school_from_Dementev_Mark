package game.engine;

import static game.creatures.Gamer.CREATURE_TYPE_GAMER;
import static game.creatures.Monster.CREATURE_TYPE_MONSTER;
import game.App;
import game.creatures.Creature;
import game.creatures.Gamer;
import game.creatures.Monster;
import game.utils.Generator;
import java.util.Scanner;

public class GameSession {
    public static final String GAMER_WIN_TEXT = "Monster is dead! Congratulations!";
    public static final String MONSTER_WIN_TEXT = "Monster is win :(! Try again to fight!";
    public static final String AGAINST_TEXT = " acts against ";
    public static final String GAMER_ROUND_EXPLANATION = "Gamer, are you attack or heal yourself?"
            + " Enter your choice - A or H.";
    public static final String HEAL_RESULT_TEXT = "Gamer healed yourself for ";
    public static final String WRONG_TURN_INPUT_ERROR = "Wrong input. Please, input A to attack Monster or H "
            + "to heal yourself, or Q to exit.";
    public static final String HEALTH_STATUS = " current health is now ";
    public static final String HEAL_COUNT_STATUS = " healing casts is now ";
    public static final String GAMER_ATTACK_SUCCESS_TEXT = "The Gamer damaged Monster for ";
    public static final String GAMER_ATTACK_FAIL_TEXT = "The Gamer attack missed the Monster! :(";
    public static final String MONSTER_ATTACK_SUCCESS_TEXT = "The Monster damaged Gamer for ";
    public static final String MONSTER_ATTACK_FAIL_TEXT = "The Monster attack missed the Gamer! :)";
    public static final String UI_ELEMENT_FIRST = "~~~~~~~~~~~~";
    public static final String UI_ELEMENT_SECOND = "------------";
    private String turnOrder;
    private Monster monster;
    private Gamer gamer;

    public GameSession(String turnOrder, Creature[] monsterAndGamer) {
        this.turnOrder = turnOrder;
        this.monster = (Monster) monsterAndGamer[0];
        this.gamer = (Gamer) monsterAndGamer[1];
    }

    public void playGame() {
        try (Scanner turnScanner = new Scanner(System.in)) {
            while (monster.getCurrentHealth() != 0 && gamer.getCurrentHealth() != 0) {
                doRound(turnScanner);
            }
        }

        if (gamer.getCurrentHealth() == 0) {
            System.out.println(MONSTER_WIN_TEXT);
        } else {
            System.out.println(GAMER_WIN_TEXT);
        }
        System.exit(0);
    }

    private void doRound(Scanner turnScanner) {
        String attackerName;
        String defenderName;
        int damageInRound = 0;

        System.out.println(UI_ELEMENT_FIRST);
        System.out.println(CREATURE_TYPE_GAMER + HEALTH_STATUS + gamer.getCurrentHealth());
        System.out.println(CREATURE_TYPE_GAMER + HEAL_COUNT_STATUS + gamer.getHealCount());
        System.out.println(UI_ELEMENT_SECOND);
        System.out.println(CREATURE_TYPE_MONSTER + HEALTH_STATUS + monster.getCurrentHealth());
        System.out.println(UI_ELEMENT_FIRST);

        switch (turnOrder) {
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
            default -> throw new RuntimeException(Generator.WRONG_CREATURE_TYPE_WARNING);
        }
        System.out.println(attackerName + AGAINST_TEXT + defenderName + "!");

        if (turnOrder.equals(CREATURE_TYPE_GAMER)) {
            System.out.println(GAMER_ROUND_EXPLANATION);
            doGamerTurn(turnScanner, damageInRound);
        } else {
            if (damageInRound > 0) {
                System.out.println(MONSTER_ATTACK_SUCCESS_TEXT + damageInRound + "!");
            } else {
                System.out.println(MONSTER_ATTACK_FAIL_TEXT);
            }
            gamer.setCurrentHealth(Math.max(gamer.getCurrentHealth() - damageInRound, 0));
        }

        if (turnOrder.equals(CREATURE_TYPE_GAMER)) {
            turnOrder = CREATURE_TYPE_MONSTER;
        } else {
            turnOrder = CREATURE_TYPE_GAMER;
        }
    }

    private void doGamerTurn(Scanner turnScanner, int damageInRound) {
        String playerTurnChoice = turnScanner.next();

        switch (playerTurnChoice) {
            case "A" -> {
                if (damageInRound > 0) {
                    System.out.println(GAMER_ATTACK_SUCCESS_TEXT + damageInRound + "!");
                } else {
                    System.out.println(GAMER_ATTACK_FAIL_TEXT);
                }
                monster.setCurrentHealth(Math.max(monster.getCurrentHealth() - damageInRound, 0));
            }
            case "H" -> {
                System.out.println(HEAL_RESULT_TEXT + gamer.getHealPower() + ".");
                gamer = gamer.healYourself();
            }
            case "Q" -> {
                System.out.println(App.BYE_MESSAGE);
                System.exit(0);
            }
            default -> {
                System.out.println(WRONG_TURN_INPUT_ERROR);
                doGamerTurn(turnScanner, damageInRound);
            }
        }
    }
}
