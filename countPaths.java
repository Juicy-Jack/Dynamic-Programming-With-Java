import java.util.List;
import java.util.HashMap;
public class countPaths {

    public static int countP(List<List<String>> grid){
            return countP(0, 0, grid, new HashMap<>());
    }

    public static int countP(int r, int c, List<List<String>> grid, HashMap<List<Integer>, Integer> memo){
        
        List<Integer> pos = List.of(r, c);
    

        if(memo.containsKey(pos)){
            return memo.get(pos);
        }

        if (r == grid.size() || c == grid.get(0).size()) {
            return 0;
        }

        if(grid.get(r).get(c) == "X") {
            return 0;
        }

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return 1;
        }

        int result = countP(r + 1, c, grid, memo) + countP(r, c + 1, grid, memo);

        memo.put(pos, result);
        
        return result;
    }
}
