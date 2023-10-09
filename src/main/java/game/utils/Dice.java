package game.utils;

import java.util.HashSet;

public class Dice {
    public static final int[] DICE_TYPE_SIX_SIDED = {1, 6};

    public static boolean isSuccessfulThrowOneEnough(int[] diceType, int dicesCount, HashSet<Integer> successValues) {
        for (int i = 0; i < dicesCount; i++) {
            int diceThrowResult = Generator.generateValue(diceType[0], diceType[1]);

            if (successValues.contains(diceThrowResult)) {
                return true;
            }
        }
        return false;
    }
}
