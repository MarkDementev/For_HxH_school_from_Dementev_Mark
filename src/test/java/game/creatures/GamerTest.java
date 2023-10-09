package game.creatures;

import static game.creatures.Gamer.GAMER_DEFAULT_HEAL_POWER_PERCENTAGE;
import static game.utils.Generator.VARIABLE_ERROR;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import game.utils.Generator;
import org.junit.jupiter.api.Test;

public class GamerTest {
    public static final int TEST_GAMER_ATTACK_VALUE = Generator.ATTACK_MAX_VALUE;
    public static final int[] TEST_GAMER_DAMAGE_RANGE_VALUE = {Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE};
    public static final int TEST_GAMER_PROTECTION_VALUE = Generator.PROTECTION_MAX_VALUE;
    public static final int TEST_GAMER_HEALTH_VALUE = Generator.HEALTH_MAX_VALUE;
    public static final int TEST_GAMER_HEALTH_VALUE_VERY_SMALL = Generator.HEALTH_MIN_VALUE - 1;
    public static final int TEST_GAMER_HEALTH_VALUE_VERY_BIG = Generator.HEALTH_MAX_VALUE + 1;
    public static final int TEST_GAMER_HEAL_COUNT_VALUE_VERY_SMALL = Gamer.GAMER_DEFAULT_HEAL_COUNT - 5;
    public static final int TEST_GAMER_HEAL_COUNT_VALUE_VERY_BIG = Gamer.GAMER_DEFAULT_HEAL_COUNT + 1;

    @Test
    public void testHealYourself() {
        Gamer gamer = new Gamer(TEST_GAMER_ATTACK_VALUE, TEST_GAMER_DAMAGE_RANGE_VALUE,
                TEST_GAMER_PROTECTION_VALUE, TEST_GAMER_HEALTH_VALUE);

        gamer.healYourself();
        assertEquals(TEST_GAMER_HEALTH_VALUE, gamer.getCurrentHealth());

        gamer.setHealCount(0);
        gamer.setCurrentHealth(Generator.HEALTH_MIN_VALUE);
        gamer.healYourself();
        assertEquals(Generator.HEALTH_MIN_VALUE, gamer.getCurrentHealth());

        gamer.setHealCount(1);
        gamer.healYourself();
        assertEquals(Generator.HEALTH_MIN_VALUE
                        + (int) (GAMER_DEFAULT_HEAL_POWER_PERCENTAGE * TEST_GAMER_HEALTH_VALUE),
                gamer.getCurrentHealth());
    }

    @Test
    public void testHealYourselfWithException() {
        Gamer gamer = new Gamer(TEST_GAMER_ATTACK_VALUE, TEST_GAMER_DAMAGE_RANGE_VALUE,
                TEST_GAMER_PROTECTION_VALUE, TEST_GAMER_HEALTH_VALUE_VERY_SMALL);

        IllegalArgumentException thrownFirst = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownFirst.getMessage().contains(VARIABLE_ERROR + "currentHealth"));

        gamer.setCurrentHealth(TEST_GAMER_HEALTH_VALUE_VERY_BIG);
        IllegalArgumentException thrownSecond = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownSecond.getMessage().contains(VARIABLE_ERROR + "currentHealth"));

        gamer.setCurrentHealth(TEST_GAMER_HEALTH_VALUE);
        gamer.setHealCount(TEST_GAMER_HEAL_COUNT_VALUE_VERY_SMALL);
        IllegalArgumentException thrownThird = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownThird.getMessage().contains(VARIABLE_ERROR + "healCount"));

        gamer.setHealCount(TEST_GAMER_HEAL_COUNT_VALUE_VERY_BIG);
        IllegalArgumentException thrownFourth = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownFourth.getMessage().contains(VARIABLE_ERROR + "healCount"));
    }
}
