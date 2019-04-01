public class MyLinkedList<E> {
    private class Node {
        private E data;
        private Node next, prev;

        public Node(E val) {
            data = val;
        }

        public Node next() {
            return next;
        }
        public Node prev() {
            return prev;
        }
        public E getData() {
            return data;
        }

        public void setNext(Node newN) {
            next = newN; //i did not have exceptions because it's easier to have it retunr null
        }
        public void setPrev(Node newN) {
            prev = newN;
        }
        public E setData(E i) {
            E toReturn = data;
            data = i;
            return toReturn;
        }

        public String toString() {
            return "" + data;
        }
    }

    private int length;
    private Node start, end;

    public MyLinkedList() {
        length = 0;
    }

    public void clear() {
        length = 0;
        start = null;
        end = null;
    }

    public int size() {
        return length;
    }

    public String toString() {
        Node currentNode = start;
        String ans = "[";
        for (int idx = 0; idx < size(); idx++) {
            ans += currentNode.toString() + ", "; //adds the next node's data
            if (currentNode.next() != null) {
                currentNode = currentNode.next(); //cycles through the nodes
            }
            if (idx == size() - 1) {
                ans = ans.substring(0, ans.length() - 2);
            }
        }
        return ans + "]";
    }

    public boolean add(E value) {
        Node toAdd = new Node(value);
        if (length == 0) { //special case
            start = toAdd;
            end = toAdd; //this makes it so length = 1 doesn't break
            length++;
            return true;
        }
        end.setNext(toAdd);
        toAdd.setPrev(end); //these two lines are the double link
        end = toAdd;
        length++;
        return true;
    }

    public void extend(MyLinkedList other) {
        if (size() == 0) {
            start = other.start;
            end = other.end;
            length = other.size();
            other.length = 0;
            other.start = null;
            other.end = null;
        } else if (other.size() != 0) {
            end.setNext(other.start);
            other.start.setPrev(end);
            end = other.end;
            length += other.length;
            other.end = null;
            other.start = null;
            other.length = 0;
        }
    }

    public E removeFront() {
        E toReturn = start.getData();
        start = start.next(); //resets start, but not needed to set startprev to null
        length--;
        return toReturn;
    }
}
