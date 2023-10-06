package forHxH.game.engine;

import static forHxH.game.creatures.Monster.CREATURE_TYPE_MONSTER;
import static forHxH.game.creatures.Gamer.CREATURE_TYPE_GAMER;
import forHxH.game.creatures.Creature;
import forHxH.game.utils.GenerateCreature;

public class GamePreparation {
    public static void prepareGame(String turnOrders) {
        Creature[] monsterAndGamer = new Creature[2];
        monsterAndGamer[0] = GenerateCreature.generateDefaultCreature(CREATURE_TYPE_MONSTER);
        monsterAndGamer[1] = GenerateCreature.generateDefaultCreature(CREATURE_TYPE_GAMER);

        Engine.startGame(turnOrders, monsterAndGamer);
    }
}
