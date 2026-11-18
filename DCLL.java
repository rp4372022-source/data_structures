package data_structures;

public class DCLL {
    Node head;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            // by default next and prev are null
        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            head.next = head;
            head.prev = head;
        } else {
            Node node = new Node(data);
            node.next = head;
            head.prev.next = node;
            node.prev = head.prev;
            head.prev = node;
        }
    }

    public void add(int index, int data) {
        if (head == null) {
            add(data);
        } else if (index == 0) {
            Node node = new Node(data);
            node.next = head;
            head.prev.next = node;
            node.prev = head.prev;
            head.prev = node;
            head = head.prev;
        } else {
            int cnt = 0;
            Node t = head;
            while (cnt < index - 1) {
                t = t.next;
                cnt++;
            }
            Node node = new Node(data);
            node.next = t.next;
            t.next.prev = node;
            t.next = node;
            node.prev = t;
        }
    }

    public int get(int index) {
        Node node = getNode(index);
        return node.data;
    }

    public void set(int index, int data) {
        Node node = getNode(index);
        node.data = data;
    }

    public int delete(int index) {
        Node node;
        if (index == 0) {
            node = head;
            if (head.next == head) {
                head = null;
            } else {
                head.prev.next = head.next;
                head.next.prev = head.prev;
                head = head.next;
            }
        } else {
            node = getNode(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return node.data;
    }

    public void display() {
        Node n = head;
        if (head == null) {
            System.out.println("null");
            return;
        }
        if (n.next == head) {
            System.out.println("= " + head.data + " =");
            return;
        }
        while (n.next != head) {
            System.out.print(" = " + n.data);
            n = n.next;
        }
        System.out.println(" = ");
    }

    public Node getNode(int index) {
        int cnt = 0;
        Node t = head;
        while (cnt < index) {
            t = t.next;
            if (t == null)
                throw new IndexOutOfBoundsException("Unreachable Index :" + index);
            cnt++;
        }
        return t;
    }
}