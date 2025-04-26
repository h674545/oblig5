package oblig5_uke15;

public class NodeMain {

    public static void main(String[] args) {
        
        Node<Integer> blad1 = new Node<>(1);
        Node<Integer> blad3 = new Node<>(3);
        Node<Integer> blad5 = new Node<>(5);
        Node<Integer> blad7 = new Node<>(7);
        
        Node<Integer> node2 = new Node<>(2, blad1, blad3);
        Node<Integer> node6 = new Node<>(6, blad5, blad7);
        
        Node<Integer> roten = new Node<>(4, node2, node6);


        skrivUtInOrder(roten);
    }
    
    private static void skrivUtInOrder(Node<Integer> node) {
        if (node != null) {
            skrivUtInOrder(node.left);
            System.out.print(node.data + " ");
            skrivUtInOrder(node.right);
        }
    }
}
