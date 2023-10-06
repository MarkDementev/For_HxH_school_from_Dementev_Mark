package forHxH.game.creatures;

public abstract class Creature {
    protected final int attack;
    protected final int[] damage;
    protected final int protection;
    protected final int maxHealth;
    protected int currentHealth;

    public Creature(int attack, int[] damage, int protection, int health) {
        this.attack = attack;
        this.damage = damage;
        this.protection = protection;
        this.maxHealth = health;
        this.currentHealth = health;
    }

    public abstract void attack();
}
