import java.util.HashMap;
import java.util.List;

public class sumPossible {
    
    public static boolean sumPoss(int amount, List<Integer> numbers){
        return sumPoss(amount, numbers, new HashMap<>());
    }

    public static boolean sumPoss(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo){



        if (amount == 0){
            return true;
        }

        if (amount < 0){
            return false;
        }

        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        for (int num: numbers){
            int subAmount = amount - num;
            if(sumPoss(subAmount, numbers, memo)){
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }

    public static void main(String[] args){
        boolean x = sumPoss(10, List.of(4, 5, 7));
        System.out.println(x);
    } 
}
