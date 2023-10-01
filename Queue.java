import java.util.Arrays;

public class Queue {
    final int MAXSIZE = 100;
    private int size;
    private int[] queueADT;
    private int front = 0;
    private int rear = -1;

    public Queue() {
        size = MAXSIZE;
        queueADT = new int[size];
    }

    public Queue(int inputsize) {
        size = inputsize;
        queueADT = new int[size];
    }

    public boolean empty() {
        return (rear < front);
    }

    public boolean full() { 
        return (rear == size - 1);
    }

    public void enqueue(int number) {
        rear++;
        queueADT[rear] = number;
    }

    public int dequeue() {
        front++;
        return queueADT[front - 1];
    }

    public int front() {
        return queueADT[front];
    }

    public int size() {
        return (rear + 1 - front);
    }

    public void print() {
        // must print between rear and front including front and rear
    }
}