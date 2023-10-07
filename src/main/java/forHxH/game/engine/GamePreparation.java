package forHxH.game.engine;

import static forHxH.game.creatures.Monster.CREATURE_TYPE_MONSTER;
import static forHxH.game.creatures.Gamer.CREATURE_TYPE_GAMER;
import forHxH.game.creatures.Creature;
import forHxH.game.utils.Generator;

public class GamePreparation {
    public static void prepareGame(String turnOrder) {
        Creature[] monsterAndGamer = new Creature[2];
        monsterAndGamer[0] = Generator.generateDefaultCreature(CREATURE_TYPE_MONSTER);
        monsterAndGamer[1] = Generator.generateDefaultCreature(CREATURE_TYPE_GAMER);

        GameSession gameSession = new GameSession(turnOrder, monsterAndGamer);
        gameSession.playGame();
    }
}
