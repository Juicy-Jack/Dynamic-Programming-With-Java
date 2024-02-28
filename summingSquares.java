import java.util.HashMap;

public class summingSquares {

    public static int summingS(int n) {
        return summingS(n, new HashMap<>());
    }

    public static int summingS(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        double minSquares = Double.POSITIVE_INFINITY;

        for(int i = 1; i <= Math.sqrt(n); i += 1) {
            int square = i * i;
            int numSquares = 1 + summingS(n - square, memo);
            if (numSquares < minSquares) {
                minSquares = numSquares;
            }
        }

        int result = (int) minSquares;
        memo.put(n, result);
        return result;
    }
}
