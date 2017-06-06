import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* Solver utils class provides some helper methods like creating initial state.
 */
public class SolverUtils {

    // Generate state that all queens have row # 0
    public static int[] generateAllOneState(int n) {

        return new int[n];
    }

    // Randomizes state
    public static int[] randomizeState(int[] r) {

        for (int i = 0; i < r.length; i++)
            r[i] = (int) (Math.random() * r.length);

        return r;
    }

    // generates random initial state
    public static int[] generateRandomState(int n) {

        return randomizeState(generateAllOneState(n));
    }

    // Returns heuristic cost
    public static int getHeuristicCost(int[] r) {
        int h = 0;

        // increment cost if two queens are in same row or in same diagonal.
        for (int i = 0; i < r.length; i++)
            for (int j = i + 1; j < r.length; j++)
                if (r[i] == r[j] || Math.abs(r[i] - r[j]) == j - i)
                    h += 1;

        return h;
    }



}
