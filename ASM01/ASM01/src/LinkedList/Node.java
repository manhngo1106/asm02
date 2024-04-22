package LinkedList;

public class Node<T> {
    private T data; // Data stored in the node
    private Node<T> next; // Reference to the next node

    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // Getter and setter methods
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
