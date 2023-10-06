package forHxH.game.creatures;

public abstract class Creature {
    private final int attack;
    private final int[] damage;
    private final int protection;
    private final int maxHealth;
    private int currentHealth;

    public Creature(int attack, int[] damage, int protection, int health) {
        this.attack = attack;
        this.damage = damage;
        this.protection = protection;
        this.maxHealth = health;
        this.currentHealth = health;
    }

    public int getAttack() {
        return attack;
    }

    public int[] getDamage() {
        return damage;
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

    public void attack() {

    }
}
