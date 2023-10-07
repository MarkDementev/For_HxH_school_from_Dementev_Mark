package game.creatures;

public class Monster extends Creature {
    public static final String CREATURE_TYPE_MONSTER = "Monster";

    public Monster(int attack, int[] damageRange, int protection, int health) {
        super(attack, damageRange, protection, health);
    }
}
