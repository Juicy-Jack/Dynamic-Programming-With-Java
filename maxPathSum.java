import java.util.HashMap;
import java.util.List;

public class maxPathSum {

    public static int maxPathS(List<List<Integer>> grid){
        return (int) maxPathS(0, 0, grid, new HashMap<>());
    }
    
    public static double maxPathS(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Double> memo) {

        List<Integer> pos = List.of(r, c);

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        if (r == grid.size() || c == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }

        if (r == grid.size() - 1 && c == grid.get(0).size() -1) {
            return grid.get(r).get(c);
        }

        double result = grid.get(r).get(c) + Math.max(maxPathS(r + 1, c, grid, memo), maxPathS(r, c + 1, grid, memo));

        memo.put(pos, result);

        return result;
    }
}
