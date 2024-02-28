import java.util.List;
import java.util.HashMap;

public class minChange {

    public static int minCh(int amount, List<Integer> coins){
        return minCh(amount, coins, new HashMap<>());
    }

    public static int minCh(int amount, List<Integer> coins, HashMap<Integer, Integer> memo){
        if (amount == 0){
            return 0;
        }

        if(amount < 0){
            return -1;
        }

        int minCoins = -1;

        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        for(int coin : coins){
            int subAmount = amount - coin;
            int subCoins = minCh(subAmount, coins, memo);
            if(subCoins != -1){
                int numCoins = subCoins + 1;
                if(numCoins < minCoins || minCoins == -1){
                    minCoins = numCoins;
                }
            }
        }

        memo.put(amount, minCoins);
        return minCoins;
    }
    public static void main(String[] args){
        
    }
}
