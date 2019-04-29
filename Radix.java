import java.lang.Math;
@SuppressWarnings({"unchecked", "rawtypes"})

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

        int numDigs = ("" + max).length(); //finds num of digits
        MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
        for (int i = 0; i < buckets.length; i++) { //first pass to put data into mylinked list
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
        MyLinkedList<Integer> sortedish = new MyLinkedList<Integer>(); //linkedlist that makes it easy and quick
        for (int i = 0; i < buckets.length; i++) {
            sortedish.extend(buckets[i]);
        }

        for (int place = 1; place < numDigs; place++) {
            for (int i = 0; i < data.length; i++) {
                int num = sortedish.removeFront(); //stores the first number
                int digit = Math.abs((num / (int)Math.pow(10, place)) % 10); //complicated math to find a certain digit
                if (num >= 0) {
                    buckets[digit + 10].add(num); //the positive number case
                } else {
                    buckets[9 - digit].add(num); //the negative number case
                }
            }
            for (int i = 0; i < buckets.length; i++) {
                sortedish.extend(buckets[i]);
            }
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = sortedish.removeFront();
        }
    }
}
