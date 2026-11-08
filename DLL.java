package data_structures;

public class DLL{
    public Node head;
    public Node tail = head;

    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            prev = null;
            next = null;
        }
    } 

    public void add(int data){
        if(head == null){
            head = new Node(data);
            tail = head;
            return;
        }

        tail.next = new Node(data);
        tail.next.prev = tail;
        tail = tail.next;
        
    }

    public void insert(int index, int data){
        
        // insert at beginning
        if(index == 0){
            if(head == null){
                head = new Node(data);
            } else {
                Node newNode = new Node(data);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } 
        else {
            Node insertingNode = new Node(data);
            Node traveller = head;
            int ptr = 0;
            while(ptr < index-1){
                traveller = traveller.next;
                ptr++;
            }
            insertingNode.next = traveller.next;
            traveller.next.prev = insertingNode;

            insertingNode.prev = traveller;
            traveller.next = insertingNode;
        }
    }

    public void set(int index, int data){
        if(index == 0){
            head.data = data;
        } else {
            Node traveller = head;
            int ptr = 0;
            while(ptr < index){
                traveller = traveller.next;
            }
            traveller.data = data;
        }
    }

    public void delete(int index){
        if(head == null){
            throw new IllegalAccessError("List empty hai bhai");
        }
        else {
            Node traveller = head;
            int ptr = 0;
            while(ptr < index){
                traveller = traveller.next;
                ptr++;
            }
            traveller.prev.next = traveller.next;
            traveller.next.prev = traveller.prev;
        }
    }

    public int get(int index){
        if(head == null)
            throw new IllegalAccessError("List empty hai");
        Node traveller = head;
        int ptr = 0;
        while(ptr < index){
            traveller = traveller.next;
        }
        return traveller.data;
    }

    public void display(){
        
        Node traveller = head;
        System.out.print("null = ");
        while(traveller != null){
            System.out.print(traveller.data + " = ");
            traveller = traveller.next;
        }
        System.out.println("null");
    }

    public void displayReversed(){
        
        Node traveller = tail;
        System.out.print("null = ");
        while(traveller != null){
            System.out.print(traveller.data + " = ");
            traveller = traveller.prev;
        }
        System.out.println("null");
    }
}
