package forHxH.game.creatures;

import forHxH.game.actions.Heal;

public class Gamer extends Creature implements Heal {
    public static final String CREATURE_TYPE_GAMER = "Gamer";
    private int healCount = 4;
    private final int healPower = (int) (0.3 * getMaxHealth());

    public Gamer(int attack, int[] damageRange, int protection, int health) {
        super(attack, damageRange, protection, health);
    }

    public int getHealCount() {
        return healCount;
    }

    public void setHealCount(int healCount) {
        this.healCount = healCount;
    }

    @Override
    public Creature healYourself() {
        if (healCount >= 0) {
            healCount--;
            setCurrentHealth(Math.min(getCurrentHealth() + healPower, getMaxHealth()));
            return this;
        }
        System.out.println(NO_HEAL_CASTS_ERROR);

        return this;
    }
}
