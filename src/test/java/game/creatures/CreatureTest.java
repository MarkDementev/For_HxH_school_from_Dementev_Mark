package game.creatures;

import static game.utils.Generator.VARIABLE_ERROR;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import game.utils.Generator;
import org.junit.jupiter.api.Test;

public class CreatureTest {
//    @Test
//    public void attackAndCalculateDamage() {
//        Gamer gamer = new Gamer(Generator.ATTACK_MAX_VALUE,
//                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
//                Generator.PROTECTION_MAX_VALUE,
//                Generator.HEALTH_MAX_VALUE);
//        Monster monster = new Monster(Generator.ATTACK_MAX_VALUE,
//                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
//                Generator.PROTECTION_MAX_VALUE,
//                Generator.HEALTH_MAX_VALUE);
//
//        IllegalArgumentException thrownFirst = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownFirst.getMessage().contains(VARIABLE_ERROR + "currentHealth"));
//
//        gamer.setCurrentHealth(TEST_GAMER_HEALTH_VALUE_VERY_BIG);
//        IllegalArgumentException thrownSecond = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownSecond.getMessage().contains(VARIABLE_ERROR + "currentHealth"));
//
//        gamer.setCurrentHealth(TEST_GAMER_HEALTH_VALUE);
//        gamer.setHealCount(TEST_GAMER_HEAL_COUNT_VALUE_VERY_SMALL);
//        IllegalArgumentException thrownThird = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownThird.getMessage().contains(VARIABLE_ERROR + "attack"));
//
//        gamer.setHealCount(TEST_GAMER_HEAL_COUNT_VALUE_VERY_BIG);
//        IllegalArgumentException thrownFourth = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownFourth.getMessage().contains(VARIABLE_ERROR + "attack"));
//
//        IllegalArgumentException thrownFirst = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownFirst.getMessage().contains(VARIABLE_ERROR + "protection"));
//
//        gamer.setCurrentHealth(TEST_GAMER_HEALTH_VALUE_VERY_BIG);
//        IllegalArgumentException thrownSixth = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownSecond.getMessage().contains(VARIABLE_ERROR + "protection"));
//
//        gamer.setCurrentHealth(TEST_GAMER_HEALTH_VALUE);
//        gamer.setHealCount(TEST_GAMER_HEAL_COUNT_VALUE_VERY_SMALL);
//        IllegalArgumentException thrownSeventh = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownThird.getMessage().contains(VARIABLE_ERROR + "damageRange"));
//
//        gamer.setHealCount(TEST_GAMER_HEAL_COUNT_VALUE_VERY_BIG);
//        IllegalArgumentException thrownEighth = assertThrows(
//                IllegalArgumentException.class,
//                gamer::healYourself
//        );
//        assertTrue(thrownFourth.getMessage().contains(VARIABLE_ERROR + "damageRange"));
//    }
}
