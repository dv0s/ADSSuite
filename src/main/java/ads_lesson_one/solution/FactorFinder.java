// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_one.solution;

import ads_lesson_one.tools.*;

// sample primes: 10000019, 100000007, 4712020471, 142112242123, 34524689549219 
// 10000019 * 10000169 = 100001880003211‬
// 901234589 * 10000169 = 9012498198645541
// 901234589 * 904265051 = 814954941585049039
public class FactorFinder {

    /**
     * loop counter
     */
    private long count;

    /**
     * menu and runner
     */
    public void run() {
        while (true) {
            int choice = Konsole.readInt("[1=simple, 2=better, 3:best] : ", 0, 3);
            if (choice == 0) {
                break;
            }
            runVersion(choice);
        }
    }

    /**
     * run the selected version of the algorithm
     *
     * @param v: version number
     */
    private void runVersion(int v) {
        while (true) {
            long n = Konsole.readLong("Number to crunch: ", 0, 999999999999999999L);
            if (n == 0) {
                break;
            }
            count = 0;
            long factor = n;
            switch (v) {
                case 1 ->
                    factor = findFactorSimple(n);
                case 2 ->
                    factor = findFactorBetter(n);
                case 3 ->
                    factor = findFactorBest(n);
            }
            Konsole.writeLine("Factor {0} found in {1} steps", factor, count);
        }
    }

    /**
     * find a factor the simple way
     *
     * @param n
     * @return the factor found, or n if none
     */
    private long findFactorSimple(long n) {
        for (long i = 2; i < n; i++) {
            count++;
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

    /**
     * find a factor twice as fast
     *
     * @param n
     * @return the factor found, or n if none
     */
    private long findFactorBetter(long n) {
        if (n % 2 == 0) {
            count++;
            return 2;
        }
        for (long i = 3; i < n; i += 2) {
            count++;
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

    /**
     * find a factor real smart
     *
     * @param n
     * @return the factor found, or n if none
     */
    private long findFactorBest(long n) {
        if (n % 2 == 0) {
            count++;
            return 2;
        }
        long root = (long) Math.sqrt(n);
        for (long i = 3; i <= root; i += 2) {
            count++;
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

}
