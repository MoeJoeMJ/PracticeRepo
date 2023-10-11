class Node<T> {
    private T data;
    Node<T> next;
    
    public Node(T data) {
        this.data = data;
    }
    
}
class LinkedList<T> {
    
    private Node<T> head;
    private int size;
    
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head==null) {
            head = newNode;
        }
        else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    public void remove() {
        Node<T> temp = head;
        if (temp.next == null) {
            head = null;
            size--;
            return;
        }
        Node<T> currentNode = (head.next) != null ? head.next : null;
        while (currentNode != null && currentNode.next != null) {
            temp = currentNode;
            currentNode = currentNode.next;
        }
        temp.next = null;
        size--;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
    
}
public class LinkedListUsingGenerics {
    public static void main(String[] args) {

        LinkedList<Integer> myList = new LinkedList<>();

        myList.add(1);
        myList.add(2);
        myList.add(5);
        System.out.println(myList.isEmpty());
        System.out.println(myList.getSize());

        myList.remove();
        myList.remove();
        myList.remove();
        System.out.println(myList.isEmpty());

    }
}
