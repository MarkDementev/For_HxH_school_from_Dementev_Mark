package game.creatures;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import game.utils.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void makePlayer() {
        player = new Player(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);
    }

    @Test
    public void testHealYourself() {
        player.healYourself();
        assertEquals(Generator.HEALTH_MAX_VALUE, player.getCurrentHealth());

        player.setHealCount(0);
        player.setCurrentHealth(Generator.HEALTH_MIN_VALUE);
        player.healYourself();
        assertEquals(Generator.HEALTH_MIN_VALUE, player.getCurrentHealth());

        player.setHealCount(1);
        player.healYourself();
        assertEquals(Generator.HEALTH_MIN_VALUE
                        + (int) (Player.PLAYER_DEFAULT_HEAL_POWER_PERCENTAGE * Generator.HEALTH_MAX_VALUE),
                player.getCurrentHealth());
    }

    @Test
    public void testHealYourselfWithException() {
        player.setCurrentHealth(Generator.HEALTH_MIN_VALUE - 1);
        IllegalArgumentException thrownFirst = assertThrows(
                IllegalArgumentException.class,
                player::healYourself
        );
        assertTrue(thrownFirst.getMessage().contains(Generator.VARIABLE_ERROR + "currentHealth"));

        player.setCurrentHealth(Generator.HEALTH_MAX_VALUE + 1);
        IllegalArgumentException thrownSecond = assertThrows(
                IllegalArgumentException.class,
                player::healYourself
        );
        assertTrue(thrownSecond.getMessage().contains(Generator.VARIABLE_ERROR + "currentHealth"));

        player.setCurrentHealth(Generator.HEALTH_MAX_VALUE);
        player.setHealCount(-1);
        IllegalArgumentException thrownThird = assertThrows(
                IllegalArgumentException.class,
                player::healYourself
        );
        assertTrue(thrownThird.getMessage().contains(Generator.VARIABLE_ERROR + "healCount"));

        player.setHealCount(Player.PLAYER_DEFAULT_HEAL_COUNT + 1);
        IllegalArgumentException thrownFourth = assertThrows(
                IllegalArgumentException.class,
                player::healYourself
        );
        assertTrue(thrownFourth.getMessage().contains(Generator.VARIABLE_ERROR + "healCount"));
    }
}
