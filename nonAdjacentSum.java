import java.util.List;
import java.util.HashMap;

public class nonAdjacentSum {
 
    public static int nonAdjacentS(List<Integer> nums) {
        return nonAdjacentS(nums, 0, new HashMap<>());
    }

    public static int nonAdjacentS(List<Integer> nums, int i, HashMap<Integer, Integer> memo) {

        if (i >= nums.size()) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int result =  Math.max(nums.get(i) + nonAdjacentS(nums, i + 2, memo), 
        nonAdjacentS(nums, i + 1, memo));
    
        memo.put(i, result);
        return result;
    }
}
