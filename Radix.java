import java.lang.Math;

public class Radix {
    public static void radixsort(int[] data) {
        if (data.length == 0) {
            return;
        }
        int max = Math.abs(data[0]);
        for (int i = 1; i < data.length; i++) {
            if (Math.abs(data[i]) > max) {
                max = Math.abs(data[i]);
            }
        }

        int numDigs = ("" + max).length();
        MyLinkedList[] buckets = new MyLinkedList[20];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyLinkedList<Integer>();
        }
        for (int i = 0; i < data.length; i++) {
            int digit = Math.abs(data[i] % 10);
            if (data[i] >= 0) {
                buckets[digit + 10].add(data[i]);
            } else {
                buckets[9 - digit].add(data[i]);
            }
        }
        MyLinkedList<Integer> sortedish = new MyLinkedList<Integers>();
        for (int i = 0; i < buckets.length; i++) {
            sortedish.extend(buckets[i]);
        }
    }
}
