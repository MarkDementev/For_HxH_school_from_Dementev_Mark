package game.utils;

import static game.creatures.Player.CREATURE_TYPE_PLAYER;
import static game.creatures.Monster.CREATURE_TYPE_MONSTER;
import static game.utils.Generator.WRONG_CREATURE_TYPE_WARNING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import game.creatures.Player;
import game.creatures.Monster;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GeneratorTest {
    public static final int GENERATOR_TESTS_STEPS = 1000;
    public static final int GENERATOR_TESTS_MIN_VALUE = Generator.ATTACK_MIN_VALUE;
    public static final int GENERATOR_TESTS_MAX_VALUE = Generator.ATTACK_MAX_VALUE;
    public static final String CREATURE_NOT_EXIST_TYPE = "Not exist creature";

    @Test
    public void testGenerateValue() {
        ArrayList<Integer> testList = new ArrayList<>();

        for (int i = 0; i < GENERATOR_TESTS_STEPS; i++) {
            int newElement = Generator.generateValue(GENERATOR_TESTS_MIN_VALUE, GENERATOR_TESTS_MAX_VALUE);

            if (newElement <= GENERATOR_TESTS_MAX_VALUE && newElement >= GENERATOR_TESTS_MIN_VALUE) {
                testList.add(newElement);
            }
        }
        assertEquals(GENERATOR_TESTS_STEPS, testList.size());
    }

    @Test
    public void testGenerateDefaultCreature() {
        Monster monster = (Monster) Generator.generateDefaultCreature(CREATURE_TYPE_MONSTER);
        Player player = (Player) Generator.generateDefaultCreature(CREATURE_TYPE_PLAYER);

        assertNotNull(monster);
        assertNotNull(monster.getDamageRange());

        assertNotNull(player);
        assertNotNull(player.getDamageRange());
    }

    @Test
    public void testGenerateDefaultCreatureWithException() {
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> Generator.generateDefaultCreature(CREATURE_NOT_EXIST_TYPE)
        );
        assertTrue(thrown.getMessage().contains(WRONG_CREATURE_TYPE_WARNING));
    }
}
