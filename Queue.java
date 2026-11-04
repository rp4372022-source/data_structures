package data_structures;

public class Queue {
    private SLL queueSll = new SLL();
    private int front = -1;
    private int rear = -1;

    public void enqueue(int data){
        if(rear == -1){
            front = 0;
            rear = 0;
        }
        queueSll.add(rear,data);
        rear++;
    }

    public int dequeue(){
        int deletedData = queueSll.delete(front);
        front++;
        return deletedData;
    }

    public int peek(){
        return rear;
    }

    public void display() {
        queueSll.printList();
    }
}
