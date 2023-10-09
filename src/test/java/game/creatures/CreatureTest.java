package game.creatures;

import static game.creatures.GamerTest.TEST_GAMER_ATTACK_VALUE;
import static game.creatures.GamerTest.TEST_GAMER_DAMAGE_RANGE_VALUE;
import static game.creatures.GamerTest.TEST_GAMER_PROTECTION_VALUE;
import static game.creatures.GamerTest.TEST_GAMER_HEALTH_VALUE;
import game.utils.Generator;
import org.junit.jupiter.api.Test;

public class CreatureTest {
    public static final int TEST_MONSTER_ATTACK_VALUE = Generator.ATTACK_MAX_VALUE;
    public static final int[] TEST_MONSTER_DAMAGE_RANGE_VALUE = {Generator.DAMAGE_MIN_VALUE,
            Generator.DAMAGE_MAX_VALUE};
    public static final int TEST_MONSTER_PROTECTION_VALUE = Generator.PROTECTION_MAX_VALUE;
    public static final int TEST_MONSTER_HEALTH_VALUE = Generator.HEALTH_MAX_VALUE;
    public static final int CREATURE_TESTS_STEPS = 100;

    @Test
    public void attackAndCalculateDamage() {
        Gamer gamer = new Gamer(TEST_GAMER_ATTACK_VALUE, TEST_GAMER_DAMAGE_RANGE_VALUE,
                TEST_GAMER_PROTECTION_VALUE, TEST_GAMER_HEALTH_VALUE);
        Monster monster = new Monster(TEST_MONSTER_ATTACK_VALUE, TEST_MONSTER_DAMAGE_RANGE_VALUE,
                TEST_MONSTER_PROTECTION_VALUE, TEST_MONSTER_HEALTH_VALUE);
        gamer.attackAndCalculateDamage(monster);
    }

    @Test
    public void attackAndCalculateDamageWithException() {

    }
}
