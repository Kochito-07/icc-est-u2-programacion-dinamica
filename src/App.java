public class App {
    public static void main(String[] args) throws Exception {
        //runFibonacci();
        //runFibonacciRecursivoPD();
        runFibonacciIterativo();
        runFibonacciIterativo2();
        runMaze();
    }

    private static void runFibonacciIterativo2() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIterativo2(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci iterativo 2 de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    private static void runFibonacciIterativo() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIterativo(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci iterativo de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    private static void runFibonacci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci recursivo de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

    private static void runFibonacciRecursivoPD() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciRecursivoPD(num, new long[num + 1]);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci recursivo con programación dinámica de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacciRecursivoPD(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = getFibonacciRecursivoPD(n - 1, memo) 
                    + getFibonacciRecursivoPD(n - 2, memo);
        return memo[n];
    }

    public static long fibonacci(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    public static long fibonacci(int n) {
        if (n <= 1) { return n; }
        long[] dp = new long[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static long getFibonacciIterativo2(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static long getFibonacciIterativo(int n) {
        if (n <= 1) {
            return n;
        }
        long[] memo = new long[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    private static void runMaze() {
        Maze miLaberinto = new Maze();
        miLaberinto.resolver();
    }
}
