package oblig5_uke15;

public class treBS<T extends Comparable<T>> {

    Node<T> rot;

    public static void main(String[] args) {
        treBS<Integer> tre = new treBS<>();
        tre.settInn(new Node<>(2));
        tre.settInn(new Node<>(1));
        tre.settInn(new Node<>(5));
        tre.settInn(new Node<>(3));
        tre.settInn(new Node<>(4));
        tre.skrivUt();
    }

    public void skrivUt() {
        skrivUtRek(rot);
    }

    private void skrivUtRek(Node<T> rot) {
        if (rot != null) {
            skrivUtRek(rot.left);
            System.out.println(rot.data);
            skrivUtRek(rot.right);
        }
    }

    private void settInn(Node<T> node) {
        rot = settInnHjelper(rot, node);
    }

    private Node<T> settInnHjelper(Node<T> rot, Node<T> node) {
        if (rot == null) {
            return node;
        } else if (node.data.compareTo(rot.data) < 0) {
            rot.left = settInnHjelper(rot.left, node);
        } else {
            rot.right = settInnHjelper(rot.right, node);
        }
        return rot;
    }
}
