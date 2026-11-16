package data_structures;

public class SCLL {
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
            tail.next = head; //pointing back to head
        }
    }

    public void add(int index, int data){
        if(index < 0) throw new IndexOutOfBoundsException("Invalid index :"+index);
        if(index == 0 && head == null) {
            add(data);
        }
        else if(index == 0){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            tail.next = head;
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
                tail = null;
            }
            head = head.next;
            return data;
        }

        Node temp = head;
        int counter = 0;
        while(counter < index - 1){
            if(temp == null || temp.next == null) throw new IndexOutOfBoundsException("Unreachable index :"+index);
            temp = temp.next;
            counter++;
        }
        //the last check
        if (temp.next == null) {
            throw new IndexOutOfBoundsException("Unreachable index :"+index);
        }
        else if(temp.next == tail){ //if deleting ele on last index update tail
            int deletedNodeData = tail.data;
            tail = temp;
            tail.next = head;
            return deletedNodeData;
        }
        int deletedNodeData = temp.next.data;
        temp.next = temp.next.next;

        return deletedNodeData;
    } 

    public void set(int index, int data){
        if(index < 0) throw new IndexOutOfBoundsException("Unreachable index :"+index);
        if(head == null) throw new IllegalStateException("List is empty");

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
        if(head == null) throw new IllegalStateException("List is empty");

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

    public void display(){
        Node printNode = head;
        System.out.print("->");
        while(printNode != tail){
            System.out.print(printNode.data +" -> ");
            printNode = printNode.next;
        }
        
        System.out.println(tail.data+" ->");
    }
}
