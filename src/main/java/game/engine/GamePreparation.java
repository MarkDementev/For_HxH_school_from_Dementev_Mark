package game.engine;

import static game.creatures.Monster.CREATURE_TYPE_MONSTER;
import static game.creatures.Player.CREATURE_TYPE_PLAYER;
import game.creatures.Creature;
import game.utils.Generator;

public class GamePreparation {
    public static void prepareGame(String turnOrder) {
        Creature[] monsterAndPlayer = new Creature[2];
        monsterAndPlayer[0] = Generator.generateDefaultCreature(CREATURE_TYPE_MONSTER);
        monsterAndPlayer[1] = Generator.generateDefaultCreature(CREATURE_TYPE_PLAYER);

        GameSession gameSession = new GameSession(turnOrder, monsterAndPlayer);
        gameSession.playGame();
    }
}
