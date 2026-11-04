package data_structures;

public class Stack {
    private SLL stackSll = new SLL();
    private int top = -1;

    void push(int data){
        stackSll.add(data);
        top++;
    }

    int pop(){
        if(top == -1) throw new IllegalArgumentException("stack khali hai biro");
        return stackSll.delete(top);
    }

    int peek(){
        return top;
    }

    void display(){
        stackSll.printList();
    }
}