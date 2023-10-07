package forHxH.game.utils;

import java.util.HashSet;

public class Dices {
    public static final int DICE_TYPE_SIX_SIDED = 6;

    public static boolean isSuccessfulThrow(int diceType, int dicesCount, HashSet<Integer> successValues) {
        for (int i = 0; i < dicesCount; i++) {
            int diceThrowResult = throwDice(diceType);

            if(successValues.contains(diceThrowResult)) {
                return true;
            }
        }
        return false;
    }

    private static int throwDice(int diceType) {
        return (int) (Math.random() * diceType + 1);
    }
}
