import java.util.HashMap;

public class tribonacci {
    public static int tri(int n){
        return tri(n, new HashMap<>());
    }

    public static int tri(int n, HashMap<Integer, Integer> memo){
        
        if(n == 0 || n == 1){
            return 0;
        }
        else if (n == 2){
            return 1;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = tri(n - 1, memo) + tri(n - 2, memo) + tri(n - 3, memo);

        memo.put(n, result);
        
        return result;
    }

    public static void main(String[] args){
        int x = tri(37);
        System.out.println(x);
    }
}
