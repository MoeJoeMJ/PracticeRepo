class Node<T> {
    private T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        next= null;
    }

}
class Queue<T> {
    private Node<T> front;
    private Node<T> back;

    public Queue(){
        front = null;
        back = null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        }
        back.next = newNode;
        back = newNode;
    }

    public void dequeue() {
        front = front.next;
        if (front == null) {
            back = null;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

}

public class QueueUsingGenerics {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        System.out.println(queue.isEmpty());  // Outputs false

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty()); // Outputs true
    }

}
