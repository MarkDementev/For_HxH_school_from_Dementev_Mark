package game.creatures;

import game.utils.Dices;
import game.utils.Generator;
import java.util.HashSet;

public abstract class Creature {
    public static final int[] CREATURE_DEFAULT_SUCCESSFUL_ATTACK_VALUES = {5, 6};
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

        for (int successfulValue : CREATURE_DEFAULT_SUCCESSFUL_ATTACK_VALUES) {
            successValues.add(successfulValue);
        }
        boolean isSuccessfulAttack = Dices.isSuccessfulThrowOneEnough(Dices.DICE_TYPE_SIX_SIDED,
                diceCount, successValues);
        int damagePower = Generator.generateValue(damageRange[0], damageRange[1]);

        return isSuccessfulAttack ? damagePower : 0;
    }
}
