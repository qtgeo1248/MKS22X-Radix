import java.util.Arrays;

public class K2Driver {
    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;

    private static String name(int i) {
        if (i == INCREASE) {
            return "Increasing\t\t";
        } else if (i == DECREASE) {
            return "Decreasing\t\t";
        } else if (i == STANDARD) {
            return "Normal Random\t\t";
        } else if (i == SMALL_RANGE) {
            return "Random with Few Values";
        } else {
            return "Error categorizing array";
        }
    }

    private static int create(int min, int max) {
        return min + (int)(Math.random() * (max - min));
    }

    private static int[] makeArray(int size, int type) {
        int[] ans = new int[size];
        if (type == STANDARD) {
            for (int i = 0; i < size; i++) {
                ans[i] = create(-1000000, 1000000);
            }
        } else if (type == INCREASE) {
            int current = -5 * size;
            for (int i = 0; i < size; i++) {
                ans[i] = create(current, current + 10);
                current += 10;
            }
        } else if (type == DECREASE) {
            int current = 5 * size;
            for (int i = 0; i < size; i++) {
                ans[i] = create(current, current + 10);
                current -= 10;
            }
        } else if (type == SMALL_RANGE) {
            for (int i = 0; i < size; i++) {
                ans[i] = create(-5,5);
            }
        } else {
            ans = new int[0];//empty is default
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] sizes = {0, 1, 2, 3, 4, 5, 6, 7, 977, 1953, 3906, 7813, 15625, 31250, 62500, 125000, 250000, 500000, 1000000, 2000000};
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            for (int type = 0; type <= 3; type++) {
                int[] start = makeArray(size, type);
                int[] result = Arrays.copyOf(start, start.length);

                Arrays.sort(result);
                long startTime = System.currentTimeMillis();
                Radix.radixsort(start);
                long elapsedTime = System.currentTimeMillis() - startTime;

                if (Arrays.equals(start, result)) {
                    System.out.println("PASS Case " + name(type) + "\tsize: " + start.length + "\t" + elapsedTime / 1000.0 + "sec ");
                } else {
                    System.out.println("FAIL ! ERROR ! " + name(type) + "size: " + size + "  ERROR!");
                }
            }
            System.out.println();
        }
    }
}
