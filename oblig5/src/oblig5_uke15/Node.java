package oblig5_uke15;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right;
    int hoydeU;

    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
        hoydeU = 1;
    }
    Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.hoydeU = 1 + Math.max(hoyde(left), hoyde(right));
    }

    private int hoyde(Node<T> node) {
        return (node == null) ? 0 : node.hoydeU;
    }
}