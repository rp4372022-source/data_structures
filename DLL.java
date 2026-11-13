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

    public void add(int index, int data){
        if(index < 0) throw new IndexOutOfBoundsException("Invalid index : "+index);
        
        Node insertingNode = new Node(data);
        if(index == 0 && head == null){
            head = insertingNode;
            tail = head;
            return;
        }
        if(index == 0){ //inserting at beginning
            insertingNode.next = head;
            head.prev = insertingNode;
            head = insertingNode;
            return;
        } 
        Node traveller = head;
        int ptr = 0;
        while(ptr < index-1){
            traveller = traveller.next;
            ptr++;
            if(traveller == null) throw new IndexOutOfBoundsException("Invalid index : "+index);
        }
        // if ptr == index while loop is skipped 
        // the last check
        if(traveller == null) throw new IndexOutOfBoundsException("Invalid index : "+index);
        if(traveller == tail){
            traveller.next = insertingNode;
            insertingNode.prev = traveller;
            tail = insertingNode; 
        } else {
            insertingNode.next = traveller.next;
            traveller.next.prev = insertingNode;
            insertingNode.prev = traveller;
            traveller.next = insertingNode;
        }
    }

    public void set(int index, int data){
        if(index < 0) throw new IndexOutOfBoundsException("Invalid index : "+index);
        if(head == null) throw new IndexOutOfBoundsException("List is empty");

        Node traveller = head;
        int ptr = 0;
        while(ptr < index){
            traveller = traveller.next;
            ptr++;
            if(traveller == null) throw new IndexOutOfBoundsException("Invalid index : "+index);
        }
        traveller.data = data;
    }

    public void delete(int index){
        if(index < 0) throw new IndexOutOfBoundsException("Invalid index : "+index);
        if(head == null) throw new IndexOutOfBoundsException("List is empty");
        
        if(index == 0){
            if(head == tail){
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return;
        }
        Node traveller = head;
        int ptr = 0;
        while(ptr < index){
            traveller = traveller.next;
            ptr++;
            if(traveller == null) throw new IndexOutOfBoundsException("Invalid index : "+index);
        }
        traveller.prev.next = traveller.next;
        if(traveller == tail) {
            tail = traveller.prev;
        } 
        else traveller.next.prev = traveller.prev;
    }

    public int get(int index){
        if(index < 0) throw new IndexOutOfBoundsException("Invalid index : "+index);
        if(head == null) throw new IndexOutOfBoundsException("List is empty");

        Node traveller = head;
        int ptr = 0;
        while(ptr < index){
            traveller = traveller.next;
            ptr++;
            if(traveller == null) throw new IndexOutOfBoundsException("Invalid index : "+index);
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
