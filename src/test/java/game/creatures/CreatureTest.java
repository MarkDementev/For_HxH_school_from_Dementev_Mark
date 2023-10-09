package game.creatures;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import game.utils.Generator;
import org.junit.jupiter.api.Test;

public class CreatureTest {
    @Test
    public void attackAndCalculateDamageWrongHealth() {
        Player player = new Player(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);
        Monster monster = new Monster(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);

        player.setCurrentHealth(Generator.HEALTH_MIN_VALUE - 1);
        IllegalArgumentException thrownFirst = assertThrows(
                IllegalArgumentException.class,
                () -> player.attackAndCalculateDamage(monster)
        );
        assertTrue(thrownFirst.getMessage().contains(Generator.VARIABLE_ERROR + "currentHealth"));

        player.setCurrentHealth(Generator.HEALTH_MAX_VALUE + 1);
        IllegalArgumentException thrownSecond = assertThrows(
                IllegalArgumentException.class,
                () -> player.attackAndCalculateDamage(monster)
        );
        assertTrue(thrownSecond.getMessage().contains(Generator.VARIABLE_ERROR + "currentHealth"));
    }

    @Test
    public void attackAndCalculateDamageWrongAttack() {
        Player player = new Player(Generator.ATTACK_MIN_VALUE - 1,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);
        Monster monster = new Monster(Generator.ATTACK_MAX_VALUE + 1,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);

        IllegalArgumentException thrownFirst = assertThrows(
                IllegalArgumentException.class,
                () -> player.attackAndCalculateDamage(monster)
        );
        assertTrue(thrownFirst.getMessage().contains(Generator.VARIABLE_ERROR + "attack"));

        IllegalArgumentException thrownSecond = assertThrows(
                IllegalArgumentException.class,
                () -> monster.attackAndCalculateDamage(player)
        );
        assertTrue(thrownSecond.getMessage().contains(Generator.VARIABLE_ERROR + "attack"));
    }

    @Test
    public void attackAndCalculateDamageWrongProtection() {
        Player player = new Player(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MIN_VALUE - 1,
                Generator.HEALTH_MAX_VALUE);
        Monster monster = new Monster(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE + 1,
                Generator.HEALTH_MAX_VALUE);

        IllegalArgumentException thrownFirst = assertThrows(
                IllegalArgumentException.class,
                () -> player.attackAndCalculateDamage(monster)
        );
        assertTrue(thrownFirst.getMessage().contains(Generator.VARIABLE_ERROR + "protection"));

        IllegalArgumentException thrownSecond = assertThrows(
                IllegalArgumentException.class,
                () -> monster.attackAndCalculateDamage(player)
        );
        assertTrue(thrownSecond.getMessage().contains(Generator.VARIABLE_ERROR + "protection"));
    }

    @Test
    public void attackAndCalculateDamageWrongDamage() {
        Player player = new Player(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE - 1, Generator.DAMAGE_MAX_VALUE},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);
        Monster monster = new Monster(Generator.ATTACK_MAX_VALUE,
                new int[]{Generator.DAMAGE_MIN_VALUE, Generator.DAMAGE_MAX_VALUE + 1},
                Generator.PROTECTION_MAX_VALUE,
                Generator.HEALTH_MAX_VALUE);

        IllegalArgumentException thrownFirst = assertThrows(
                IllegalArgumentException.class,
                () -> player.attackAndCalculateDamage(monster)
        );
        assertTrue(thrownFirst.getMessage().contains(Generator.VARIABLE_ERROR + "damageRange"));

        IllegalArgumentException thrownSecond = assertThrows(
                IllegalArgumentException.class,
                () -> monster.attackAndCalculateDamage(player)
        );
        assertTrue(thrownSecond.getMessage().contains(Generator.VARIABLE_ERROR + "damageRange"));
    }
}
