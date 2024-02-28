import java.util.List;
import java.util.HashMap;

public class countingChange {

    static public int countingCh(int amount, List<Integer> coins) {
        return countingCh(amount, 0, coins, new HashMap<>());
    }

    static public int countingCh (int amount, int coinIdx, List<Integer> coins, HashMap<List<Integer>, Integer> memo) {

        if (amount == 0) {
            return 1;
        }

        if (coinIdx >= coins.size()) {
            return 0;
        }

        List<Integer> key = List.of(amount, coinIdx);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int totalWays = 0;
        int value = coins.get(coinIdx);

        for (int qty = 0; qty * value <= amount; qty += 1) {
            int subAmount = amount - (qty * value);
            totalWays += countingCh(subAmount, coinIdx + 1, coins, memo);
        }
        
        memo.put(key, totalWays);
        return totalWays;
    }

    public static void main(String[] args){
        int x = countingCh(4, List.of(1, 2, 3));
        System.out.println(x);
    }
}
