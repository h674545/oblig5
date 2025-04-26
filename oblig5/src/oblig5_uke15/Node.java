package oblig5_uke15;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
    }
    
    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}