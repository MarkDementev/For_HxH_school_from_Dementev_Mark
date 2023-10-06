package forHxH.game.creatures;

import forHxH.game.actions.Heal;

public class Gamer extends Creature implements Heal {
    public static final String CREATURE_TYPE_GAMER = "Gamer";
    private int healCount = 4;
    private int healPower = (int) (0.3 * maxHealth);

    public Gamer(int attack, int[] damage, int protection, int health) {
        super(attack, damage, protection, health);
    }

    @Override
    public Creature healYourself() {
        if (healCount >= 0) {
            healCount--;
            currentHealth = Math.min(currentHealth + healPower, maxHealth);
            return this;
        }
        System.out.println(NO_HEAL_CASTS_ERROR);

        return this;
    }

    public int getHealCount() {
        return healCount;
    }

    public void setHealCount(int healCount) {
        this.healCount = healCount;
    }
}
