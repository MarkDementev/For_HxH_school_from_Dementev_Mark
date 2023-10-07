package forHxH.game.utils;

import static forHxH.game.utils.Generator.generateValue;
import java.util.HashSet;

public class Dices {
    public static final int[] DICE_TYPE_SIX_SIDED = {1, 6};

    public static boolean isSuccessfulThrowOneEnough(int[] diceType, int dicesCount, HashSet<Integer> successValues) {
        for (int i = 0; i < dicesCount; i++) {
            int diceThrowResult = generateValue(diceType[0], diceType[1]);

            if(successValues.contains(diceThrowResult)) {
                return true;
            }
        }
        return false;
    }
}
