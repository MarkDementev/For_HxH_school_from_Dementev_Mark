package game.creatures;

import static game.utils.Generator.ATTACK_MIN_VALUE;
import static game.utils.Generator.ATTACK_MAX_VALUE;
import static game.utils.Generator.PROTECTION_MIN_VALUE;
import static game.utils.Generator.PROTECTION_MAX_VALUE;
import static game.utils.Generator.DAMAGE_MIN_VALUE;
import static game.utils.Generator.DAMAGE_MAX_VALUE;
import static game.utils.Generator.HEALTH_MIN_VALUE;
import static game.utils.Generator.HEALTH_MAX_VALUE;
import static game.utils.Generator.VARIABLE_ERROR;
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
        if (currentHealth < HEALTH_MIN_VALUE || currentHealth > HEALTH_MAX_VALUE) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "currentHealth");
        }

        if (attack < ATTACK_MIN_VALUE || attack > ATTACK_MAX_VALUE) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "attack");
        }

        if (defender.protection < PROTECTION_MIN_VALUE || defender.protection > PROTECTION_MAX_VALUE) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "protection");
        }

        if (damageRange[0] < DAMAGE_MIN_VALUE || damageRange[1] > DAMAGE_MAX_VALUE) {
            throw new IllegalArgumentException(VARIABLE_ERROR + "damageRange");
        }
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
