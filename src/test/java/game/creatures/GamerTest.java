package game.creatures;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import game.utils.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamerTest {
    private Gamer gamer;

    @BeforeEach
    public void makeGamer() {
        gamer = new Gamer(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);
    }

    @Test
    public void testHealYourself() {
        gamer.healYourself();
        assertEquals(Generator.HEALTH_MAX_VALUE, gamer.getCurrentHealth());

        gamer.setHealCount(0);
        gamer.setCurrentHealth(Generator.HEALTH_MIN_VALUE);
        gamer.healYourself();
        assertEquals(Generator.HEALTH_MIN_VALUE, gamer.getCurrentHealth());

        gamer.setHealCount(1);
        gamer.healYourself();
        assertEquals(Generator.HEALTH_MIN_VALUE
                        + (int) (Gamer.GAMER_DEFAULT_HEAL_POWER_PERCENTAGE * Generator.HEALTH_MAX_VALUE),
                gamer.getCurrentHealth());
    }

    @Test
    public void testHealYourselfWithException() {
        gamer.setCurrentHealth(Generator.HEALTH_MIN_VALUE - 1);
        IllegalArgumentException thrownFirst = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownFirst.getMessage().contains(Generator.VARIABLE_ERROR + "currentHealth"));

        gamer.setCurrentHealth(Generator.HEALTH_MAX_VALUE + 1);
        IllegalArgumentException thrownSecond = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownSecond.getMessage().contains(Generator.VARIABLE_ERROR + "currentHealth"));

        gamer.setCurrentHealth(Generator.HEALTH_MAX_VALUE);
        gamer.setHealCount(-1);
        IllegalArgumentException thrownThird = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownThird.getMessage().contains(Generator.VARIABLE_ERROR + "healCount"));

        gamer.setHealCount(Gamer.GAMER_DEFAULT_HEAL_COUNT + 1);
        IllegalArgumentException thrownFourth = assertThrows(
                IllegalArgumentException.class,
                gamer::healYourself
        );
        assertTrue(thrownFourth.getMessage().contains(Generator.VARIABLE_ERROR + "healCount"));
    }
}
