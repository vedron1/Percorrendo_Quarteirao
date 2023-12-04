public class Node<X> {
    private X info;
    private Node esq, dir;

    public Node(Node esq, X info, Node dir){
        this.esq = esq;
        this.info = info;
        this.dir = dir;
    }

    public Node(X info){
        this(null, info, null);
    }

    public Node(Node esq, X info) {
        this(esq, info, null);
    }

    public Node(X info, Node dir) {
        this(null, info, dir);
    }
}
