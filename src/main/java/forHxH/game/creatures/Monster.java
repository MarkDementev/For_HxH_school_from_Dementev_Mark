package forHxH.game.creatures;

public class Monster extends Creature {
    public static final String CREATURE_TYPE_MONSTER = "Monster";

    public Monster(int attack, int[] damage, int protection, int health) {
        super(attack, damage, protection, health);
    }
}
