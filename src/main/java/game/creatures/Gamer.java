package game.creatures;

import static game.utils.Generator.HEALTH_MIN_VALUE;
import static game.utils.Generator.HEALTH_MAX_VALUE;
import static game.utils.Generator.VARIABLE_ERROR;
import game.actions.Heal;

public class Gamer extends Creature implements Heal {
    public static final String CREATURE_TYPE_GAMER = "Gamer";
    public static final String NO_HEAL_CASTS_TEXT = "Sorry, healing is not possible, too lot of healing casts!";
    public static final String FULL_HEALTH_TEXT = "Sorry, your current health is already is max!";
    public static final int GAMER_DEFAULT_HEAL_COUNT = 4;
    public static final double GAMER_DEFAULT_HEAL_POWER_PERCENTAGE = 0.3;
    private final int healPower = (int) (GAMER_DEFAULT_HEAL_POWER_PERCENTAGE * Math.abs(getMaxHealth()));
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

    public void setHealCount(int healCount) {
        this.healCount = healCount;
    }

    @Override
    public Gamer healYourself() {
        if (getCurrentHealth() < HEALTH_MIN_VALUE || getCurrentHealth() > HEALTH_MAX_VALUE) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "currentHealth");
        }

        if (healCount > GAMER_DEFAULT_HEAL_COUNT || healCount < 0) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "healCount");
        }

        if (healCount > 0 && getCurrentHealth() == getMaxHealth()) {
            System.out.println(FULL_HEALTH_TEXT);
            return this;
        } else if (healCount > 0 && getCurrentHealth() != getMaxHealth()) {
            healCount--;
            setCurrentHealth(Math.min(getCurrentHealth() + healPower, getMaxHealth()));
            return this;
        }
        System.out.println(NO_HEAL_CASTS_TEXT);
        return this;
    }
}
