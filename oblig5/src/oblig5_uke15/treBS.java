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
        
        System.out.println("Er treet balansert? " + tre.erBalansert());
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
        
        rot.hoydeU = 1 + Math.max(hoyde(rot.left), hoyde(rot.right));
        
        return rot;
    }
    
    private int hoyde(Node<T> node) {
        return (node == null) ? 0 : node.hoydeU;
    }
    
    public void skrivVerdier(T nedre, T ovre) {
        skrivVerdierRek(rot, nedre, ovre);
    }

    private void skrivVerdierRek(Node<T> node, T min, T maks) {
        if (node != null) {
            int minst = node.data.compareTo(min);
            int storst = node.data.compareTo(maks);

            if (minst > 0) {
                skrivVerdierRek(node.left, min, maks);
            }

            if (minst >= 0 && storst <= 0) {
                System.out.print(node.data + " ");
            }

            if (storst < 0) {
                skrivVerdierRek(node.right, min, maks);
            }
        }
    }
    
    public boolean erBalansert() {
        return erBalansertRek(rot);
    }
    
    private boolean erBalansertRek(Node<T> node) {
        if (node == null) {
            return true;
        }

        int venstreHoyde = (node.left != null) ? node.left.hoydeU : 0;
        int hoyreHoyde = (node.right != null) ? node.right.hoydeU : 0;

        if (Math.abs(venstreHoyde - hoyreHoyde) > 1) {
            return false;
        }

        return erBalansertRek(node.left) && erBalansertRek(node.right);
    }
}
