public class Radix {
    public static void radixsort(int[] data) {
        if (data.length == 0) {
            return;
        }
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
    }
}
