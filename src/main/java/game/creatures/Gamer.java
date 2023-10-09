package game.creatures;

import static game.utils.Generator.HEALTH_MIN_VALUE;
import static game.utils.Generator.HEALTH_MAX_VALUE;
import static game.utils.Generator.VARIABLE_ERROR;
import game.actions.Heal;

public class Gamer extends Creature implements Heal {
    public static final String CREATURE_TYPE_GAMER = "Gamer";
    public static final int GAMER_DEFAULT_HEAL_COUNT = 4;
    private final int healPower = (int) (0.3 * Math.abs(getMaxHealth()));
    private int healCount = GAMER_DEFAULT_HEAL_COUNT;

    public Gamer(int attack, int[] damageRange, int protection, int health) {
        super(attack, damageRange, protection, health);
    }

    public int getHealCount() {
        return healCount;
    }

    public int getHealPower() {
        return healPower;
    }

    @Override
    public Gamer healYourself() {
        if (getCurrentHealth() < HEALTH_MIN_VALUE || getCurrentHealth() > HEALTH_MAX_VALUE) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "currentHealth");
        }

        if (healCount > GAMER_DEFAULT_HEAL_COUNT || healCount < 0) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "healCount");
        }

        if (healCount > 0) {
            healCount--;
            setCurrentHealth(Math.min(getCurrentHealth() + healPower, getMaxHealth()));
            return this;
        }
        System.out.println(NO_HEAL_CASTS_TEXT);
        return this;
    }
}
