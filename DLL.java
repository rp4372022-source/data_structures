package data_structures;

public class DLL {
    public Node head;
    public Node tail;
    int size;

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            size++;
            return;
        } else {
            tail.next = new Node(data);
            tail.next.prev = tail;
            tail = tail.next;
            size++;
        }
    }
    public void add(int index, int data) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Invalid index : " + index);

        if (index == 0 && head == null) {
            add(data);
            return;
        }

        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }
        
        Node currNode = getNode(index - 1); // we update with node before index node so index-1
        
        if (currNode == tail)
            tail = newNode; //pointing tail to new node
        else
            currNode.next.prev = newNode;
        newNode.next = currNode.next;
        newNode.prev = currNode.prev;
        currNode.next = newNode;
        size++;
    }

    public void set(int index, int data) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Invalid index : " + index);
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");

        Node node = getNode(index);
        node.data = data;
    }

    public Node delete(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Invalid index : " + index);
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");

        Node deleteNode = null;
        if (index == 0) {
            deleteNode = head;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return deleteNode;
        } else if (index == size - 1) {
            deleteNode = tail;
            tail = tail.prev;
            tail.next = null;
            size--;
            return deleteNode;
        }
        deleteNode = getNode(index);
        deleteNode.next.prev = deleteNode.prev;
        deleteNode.prev.next = deleteNode.next;
        size--;
        return deleteNode;
    }

    public int get(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Invalid index : " + index);
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");

        Node node = getNode(index);
        return node.data;
    }

    public void display() {

        Node traveller = head;
        System.out.print("null = ");
        while (traveller != null) {
            System.out.print(traveller.data + " = ");
            traveller = traveller.next;
        }
        System.out.println("null");
    }

    public void displayReversed() {
        Node traveller = tail;
        System.out.print("null = ");
        while (traveller != null) {
            System.out.print(traveller.data + " = ");
            traveller = traveller.prev;
        }
        System.out.println("null");
    }

    public Node getNode(int index) {
        int ptr = 0;
        Node t;
        if (index < size / 2) {
            t = head;
            while (ptr < index) {
                t = t.next;
                ptr++;
            }
        } else {
            ptr = size - 1;
            t = tail;
            while (ptr > index) {
                t = t.prev;
                ptr--;
            }
        }

        if (t == null)
            throw new IllegalAccessError("No element found");
        return t;
    }
}