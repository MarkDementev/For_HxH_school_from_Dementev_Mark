package forHxH.game.actions;

import forHxH.game.creatures.Creature;

public interface Heal {
    String NO_HEAL_CASTS_ERROR = "Sorry, healing is not possible, a lot of healing casts!";
    Creature healYourself();
}
