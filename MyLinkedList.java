public class MyLinkedList {
    private class Node {
        private Integer data;
        private Node next, prev;

        public Node(int val) {
            data = val;
        }

        public Node next() {
            return next;
        }
        public Node prev() {
            return prev;
        }
        public Integer getData() {
            return data;
        }

        public void setNext(Node newN) {
            next = newN; //i did not have exceptions because it's easier to have it retunr null
        }
        public void setPrev(Node newN) {
            prev = newN;
        }
        public Integer setData(Integer i) {
            int toReturn = data;
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

    public boolean add(Integer value) {
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

    private Node getNthNode(int n) {
        if (n < 0 || n >= size()) {
            throw new IndexOutOfBoundsException(); //just for debugging for debugging purposes
        }
        Node now = start; //start at start
        for (; n > 0; n--) {
            now = now.next(); //keeps on going until you go n times
        }
        return now;
    }

    public Integer get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) { //this also makes sure that theres no errors with size 1
            return start.getData();
        } else if (index == size() - 1) { //these two ifs make it faster
            return end.getData();
        } else {
            return getNthNode(index).getData();
        }
    }

    public Integer set(int index, Integer value) { //basically the same as get, but with set
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return start.setData(value);
        } else if (index == size() - 1) {
            return end.setData(value);
        } else {
            return getNthNode(index).setData(value);
        }
    }

    public int indexOf(Integer value) {
        Node currentNode = start;
        for (int idx = 0; idx < size(); idx++) { //goes through list to see if any same
            if (currentNode.getData().equals(value)) {
                return idx;
            }
            currentNode = currentNode.next();
        }
        return -1;
    }

    public boolean contains(Integer value) {
        if (indexOf(value) > -1) { //this uses indexOf to make life easier
            return true;
        } else {
            return false;
        }
    }

    public void add(int index, Integer value) {
        Node toAdd = new Node(value); //to make life easier in ifs
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == size()) { //these 2 cases make if faster
            add(value);
        } else if (index == 0) {
            length++;
            start.setPrev(toAdd);
            toAdd.setNext(start);
            start = toAdd;
        } else {
            length++;
            Node before = getNthNode(index - 1);
            Node after = before.next();
            before.setNext(toAdd);
            toAdd.setPrev(before);
            toAdd.setNext(after); //this is all the rewiring of the nodes
            after.setPrev(toAdd);
        }
    }

    public Integer remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == size() - 1) {
            Integer toReturn = end.getData();
            end = end.prev(); //resets the end (not necessary to set end.next to null)
            length--;
            return toReturn;
        } else if (index == 0) {
            Integer toReturn = start.getData();
            start = start.next(); //resets start, but not needed to set startprev to null
            length--;
            return toReturn;
        } else {
            Node before = getNthNode(index - 1);
            Node now = before.next();
            Node after = now.next();
            Integer toReturn = now.getData();
            before.setNext(after);
            after.setPrev(before); //rewires
            length--;
            return toReturn;
        }
    }

    public boolean remove(Integer value) {
        Node currentNode = start;
        for (int idx = 0; idx < size(); idx++) { //goes through list to see if any same
            if (currentNode.getData().equals(value)) {
                if (idx == 0 || idx == size() - 1) {
                    remove(idx);
                    return true;
                } else {
                    length--;
                    currentNode.prev().setNext(currentNode.next());
                    currentNode.next().setPrev(currentNode.prev());
                    return true;
                }
            }
            currentNode = currentNode.next();
        }
        return false;
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
}
