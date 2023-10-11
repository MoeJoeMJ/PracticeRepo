class Stack<T> {

    private T[] arr;
    private int currSize;
    private static final int SIZE = 10;

    public Stack() {
        arr = (T[]) new Object[SIZE];
        currSize = 0;
    }

    public void push(T item) {
        arr[currSize++] = item;
    }

    public T pop() {
        T item = (T) arr[--currSize];
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return (T) "0";
        }
        else {
            return (T) arr[currSize - 1];
        }

    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public int getCurrSize() {
        return currSize;
    }

}

public class StackUsingGenerics {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(4);

        System.out.println("Size " + stack.getCurrSize());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
