package forHxH.game.creatures;

import static forHxH.game.utils.Dices.DICE_TYPE_SIX_SIDED;
import static forHxH.game.utils.Dices.isSuccessfulThrowOneEnough;
import static forHxH.game.utils.Generator.generateValue;
import java.util.HashSet;

public abstract class Creature {
    private final int attack;
    private final int[] damageRange;
    private final int protection;
    private final int maxHealth;
    private int currentHealth;

    public Creature(int attack, int[] damageRange, int protection, int health) {
        this.attack = attack;
        this.damageRange = damageRange;
        this.protection = protection;
        this.maxHealth = health;
        this.currentHealth = health;
    }

    public int getAttack() {
        return attack;
    }

    public int[] getDamageRange() {
        return damageRange;
    }

    public int getProtection() {
        return protection;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public int attackAndCalculateDamage(Creature defender) {
        int attackModifier = attack - defender.getProtection() + 1;
        int diceCount = Math.max(attackModifier, 1);
        HashSet<Integer> successValues = new HashSet<>();
        successValues.add(5);
        successValues.add(6);
        boolean isSuccessfulAttack = isSuccessfulThrowOneEnough(DICE_TYPE_SIX_SIDED, diceCount, successValues);
        int damagePower = generateValue(damageRange[0], damageRange[1]);

        return isSuccessfulAttack ? damagePower : 0;
    }
}
