package data_structures;

public class SLL{
    Node head;
    Node tail;

    static class Node{
        int data;
        Node next;

        Node(int d) {data = d;}
    }

    public void add(int data){
        if(head == null){ 
            head = new Node(data);
            tail = head;
        }
        else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    public void add(int index, int data){
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");
        if(head == null) {
            head = new Node(data);
            tail = head;
        }
        else if(index == 0){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            if(tail == null){
                tail = head;
            }
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int counter = 0;
        while(counter < index-1 ) {
            if(temp == null || temp.next == null) 
                throw new IllegalArgumentException("aukat nahi hai list ki "+index+" par jane ki");
            temp = temp.next;
            counter++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if(newNode.next == null) tail = newNode; 
    }

    public int delete(int index){
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");
        if(head == null) throw new IllegalStateException("List hi empty hai re");

        if(index == 0){
            int data = head.data;
            if(head == tail){
                tail = head.next;
            }
            head = head.next;
            return data;
        }

        Node temp = head;
        int counter = 0;
        while(counter < index - 1){
            if(temp == null || temp.next == null) throw new NullPointerException("List choti he babu");
            temp = temp.next;
            counter++;
        }
        //the last check
        if (temp.next == null) {
            throw new IllegalArgumentException("List choti he babu, ye index bhaar hai");
        }
        else if(temp.next == tail){ //if deleting ele on last index update tail
            int deletedNodeData = tail.data;
            temp.next = null;
            tail = temp;
            return deletedNodeData;
        }
        int deletedNodeData = temp.next.data;
        temp.next = temp.next.next;

        return deletedNodeData;
    } 

    public void set(int index, int data){
        //-ve index handling
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");
        //no head 
        //if(head == null) throw new IllegalStateException("oooeeee thats bad, no head and index is "+index+"???");

        Node temp = head;
        int counter = 0;
        while(counter < index ) {
            if(temp == null) //kya pata chalte chalte null mil jaye...
                throw new IllegalArgumentException("aukat nahi hai list ki "+index+" par jane ki");
            temp = temp.next;
            counter++;
        }
        // last check
        if(temp == null){
            throw new IllegalAccessError("Null value detected");
        }
        temp.data = data;
    }

    public int get(int index){
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");
        //if(head == null) throw new IllegalStateException("oooeeee thats bad, no head and index is "+index+"???");

        Node temp = head;
        int counter = 0;
        while(counter < index ) {
            if(temp == null) //kya pata chalte chalte null mil jaye...
                throw new IllegalArgumentException("aukat nahi hai list ki "+index+" par jane ki");
            temp = temp.next;
            counter++;
        }
        // last check
        if(temp == null){
            throw new IllegalAccessError("Null value detected");
        }
        
        return temp.data;
    }

    public void printList(){
        Node printNode = head;
        while(printNode != null){
            System.out.print(printNode.data +" -> ");
            printNode = printNode.next;
        }
        
        System.out.println("null");
    }
}