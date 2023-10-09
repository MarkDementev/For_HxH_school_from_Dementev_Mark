package game.utils;

import static game.creatures.Monster.CREATURE_TYPE_MONSTER;
import static game.creatures.Gamer.CREATURE_TYPE_GAMER;
import game.creatures.Creature;
import game.creatures.Gamer;
import game.creatures.Monster;

public class Generator {
    public static final String VARIABLE_ERROR = "The variable has an incorrect value."
            + " There was an error in the Generator code, please inform the developer! Problem variable is: ";
    public static final String WRONG_CREATURE_TYPE_WARNING = "There is unknown creature. Check it!";
    public static final int ATTACK_MIN_VALUE = 1;
    public static final int ATTACK_MAX_VALUE = 30;
    public static final int PROTECTION_MIN_VALUE = 1;
    public static final int PROTECTION_MAX_VALUE = 30;
    public static final int DAMAGE_MIN_VALUE = 1;
    public static final int DAMAGE_MAX_VALUE = 30;
    public static final int HEALTH_MIN_VALUE = 1;
    public static final int HEALTH_MAX_VALUE = 30;

    public static int generateValue(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue) + minValue);
    }

    public static int[] generateValuesRange(int minValue, int maxValue) {
        return new int[] {generateValue(minValue, maxValue), generateValue(minValue, maxValue)};
    }

    public static Creature generateDefaultCreature(String creatureType) {
        int attack = generateValue(ATTACK_MIN_VALUE, ATTACK_MAX_VALUE);
        int[] damageRange = generateValuesRange(DAMAGE_MIN_VALUE, DAMAGE_MAX_VALUE);
        int protection = generateValue(PROTECTION_MIN_VALUE, PROTECTION_MAX_VALUE);
        int health = generateValue(HEALTH_MIN_VALUE, HEALTH_MAX_VALUE);

        switch (creatureType) {
            case CREATURE_TYPE_MONSTER -> {
                return new Monster(attack, damageRange, protection, health);
            }
            case CREATURE_TYPE_GAMER -> {
                return new Gamer(attack, damageRange, protection, health);
            }
            default -> throw new RuntimeException(WRONG_CREATURE_TYPE_WARNING);
        }
    }
}
