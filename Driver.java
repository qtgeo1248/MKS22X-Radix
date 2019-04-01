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

        int[] test4 = {309, 333, -837, 847, 1046, 1112, 1398, 1515, 1533, 1678, 1721, 1906, 2145, 2466, 2688, 2699, 2901, 3060, 3158, 3191, 3515, -3640, 3684, 3946, 3965, 4075, 4079, 4091, 4175,
                       4269, 4579, 4624, -5110, 5277, 5820, 6008, 6246, -6421, 6466, 6853, 6993, 7016, 7393, 7539, 7708, 8129, 8412, 9012, 9254, 9730, -9732, 9753, 9821, -9929};
        Radix.radixsort(test4);
        System.out.println(Arrays.toString(test4));
    }
}
