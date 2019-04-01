import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[] test1 = {12, -31, 24, -42, 2, -1, 14, -21};
        Radix.radixsort(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2 = {};
        Radix.radixsort(test2);
        System.out.println(Arrays.toString(test2));

        int[] test3 = {614};
        Radix.radixsort(test3);
        System.out.println(Arrays.toString(test3));
    }
}
