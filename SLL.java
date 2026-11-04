package data_structures;

public class SLL{
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d) {data = d;}
    }

    //adding new node
    public void add(int data){
        if(head == null) head = new Node(data);
        else {
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }
    // inserting node at middle
    public void add(int index, int data){
        //-ve index handling
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");
        //no head 
        if(head == null) throw new IllegalStateException("oooeeee thats bad, no head and index is "+index+"???");
        //only head

        if(index == 0){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        else {
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
        }
    }

    //deleting node by index
    public int delete(int index){
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");

        if(head == null) throw new IllegalStateException("List hi empty hai re");

        Node temp = head;
        int counter = 0;
        
        if(index == 0){
            int data = head.data;
            head = head.next;
            return data;
        }
        while(counter < index - 1){
            if(temp == null || temp.next == null) throw new NullPointerException("List choti he babu");
            temp = temp.next;
        }
        //the last check
        if (temp.next == null) {
            throw new IllegalArgumentException("List choti he babu, ye index bhaar hai");
        }
        int deletedNodeData = temp.next.data;
        temp.next = temp.next.next;

        return deletedNodeData;
    } 

    public void set(int index, int data){
        //-ve index handling
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");
        //no head 
        if(head == null) throw new IllegalStateException("oooeeee thats bad, no head and index is "+index+"???");

        Node temp = head;
        int counter = 0;
        while(counter < index ) {
            temp = temp.next;
            counter++;
            //kya pata chalte chalte null mil jaye...
            if(temp == null) 
                throw new IllegalArgumentException("aukat nahi hai list ki "+index+" par jane ki");
        }
        temp.data = data;
    }

    public int get(int index){
        //-ve index handling
        if(index < 0) throw new IllegalStateException("ye index -ve kisne bheja be???");
        //no head 
        if(head == null) throw new IllegalStateException("oooeeee thats bad, no head and index is "+index+"???");

        Node temp = head;
        int counter = 0;
        while(counter < index ) {
            temp = temp.next;
            counter++;
            //kya pata chalte chalte null mil jaye...
            if(temp == null) 
                throw new IllegalArgumentException("aukat nahi hai list ki "+index+" par jane ki");
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