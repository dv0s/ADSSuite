package ads.tools;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Tools {

    private static final Random RANDOM = new Random();

    public static String format(long n) {
        return NumberFormat.getNumberInstance(Locale.GERMAN).format(-n);
    }

    public static int[] copyArray(int a[]) {
        int n = a.length;
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        return b;
    }

    public static void showNumbersStarred(int[] a, int i1, int i2) {
        for (int i = 0; i < a.length; i++) {
            if (i == i1 || i == i2) {
                System.out.format("%3d*", a[i]);
            } else {
                System.out.format("%3d ", a[i]);
            }
        }
        System.out.println();
    }

    public static void showNumbers(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.format("%3d ", a[i]);
        }
        System.out.println();
    }

    public static void showNumbers(List a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.format("%3d ", (int) a.get(i));
        }
        System.out.println();
    }

    public static void showNumbersIndexed(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.format("%3d:%-3d ", i, a[i]);
        }
        System.out.println();
    }

    public static void showNumbersIndexedNot0(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                System.out.format("%3d:%-3d ", i, a[i]);
            }
        }
        System.out.println();
    }

    public static void showNumbers(int[] a, int start, int end) {
        for (int i = 0; i < start; i++) {
            System.out.format("    ");
        }
        for (int i = start; i <= end; i++) {
            System.out.format("%3d ", a[i]);
        }
        System.out.println();
    }

    public static int[] generateUnsortedArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = RANDOM.nextInt(n * 3);
        }
        return a;
    }

    public static int[] generateUnsortedArray(int n, int lo, int hi) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = RANDOM.nextInt(hi + 1 - lo) + lo;
        }
        return a;
    }

    public static int[] generateSortedArray(int n) {
        int[] a = new int[n];
        int value = RANDOM.nextInt(5);
        for (int i = 0; i < n; i++) {
            a[i] = value;
            value += RANDOM.nextInt(5);
        }
        return a;
    }

    public static int[] generateSortedArray(int n, int start, int minstep, int maxstep) {

        int[] a = new int[n];
        int value = start;
        for (int i = 0; i < n; i++) {
            value += minstep + RANDOM.nextInt(maxstep - minstep);
            a[i] = value;
            value += RANDOM.nextInt(5);
        }
        return a;
    }

    public static ArrayList<Integer> generateSortedArrayList(int n, int start, int minstep, int maxstep) {

        ArrayList<Integer> a = new ArrayList<>();
        int value = start;
        for (int i = 0; i < n; i++) {
            value += minstep + RANDOM.nextInt(maxstep - minstep);
            a.add(value);
            value += RANDOM.nextInt(5);
        }
        return a;
    }
}
