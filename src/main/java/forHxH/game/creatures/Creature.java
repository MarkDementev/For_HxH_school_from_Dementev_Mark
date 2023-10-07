package forHxH.game.creatures;

import static forHxH.game.utils.Dices.DICE_TYPE_SIX_SIDED;
import static forHxH.game.utils.Dices.isSuccessfulThrow;
import java.util.HashSet;
import java.util.Set;

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

    //Method to be renamed!?
    public int attack(Creature attacker, Creature defender) {
        int attackModifier = attacker.getAttack() - defender.getProtection() + 1;
        int diceCount = Math.max(attackModifier, 1);
        HashSet<Integer> successValues = (HashSet<Integer>) Set.of(5, 6);
        boolean isSuccessfulAttack = isSuccessfulThrow(DICE_TYPE_SIX_SIDED, diceCount, successValues);
        //nt damagePower = Math.r;

        return isSuccessfulAttack ? damagePower : 0;
    }
}
