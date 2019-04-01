public class LLDriver {
    public static void main(String[] args) {
        MyLinkedList<Integer> t1 = new MyLinkedList<Integer>();
        t1.add(4);
        t1.add(3);
        System.out.println(t1);
        t1.clear();
        System.out.println(t1);
        t1.add(5);
        t1.add(6);
        t1.removeFront();
        t1.add(7);
        System.out.println(t1);

        MyLinkedList<Integer> t2 = new MyLinkedList<Integer>();
        t2.add(7);
        t2.add(8);
        t2.add(9);
        System.out.println(t2);
        t1.extend(t2);
        System.out.println(t1);
        System.out.println(t2);

        MyLinkedList<Integer> t3 = new MyLinkedList<Integer>();
        t3.add(12);
        t3.add(37);
        System.out.println(t3);
        t2.extend(t3);
        System.out.println(t2);
        System.out.println(t3);
    }
}
