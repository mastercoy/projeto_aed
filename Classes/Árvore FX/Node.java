package sample;


public class Node  {

    private Node dad;
    private Node left;
    private Node right;
    private Node next;
    private int info;

    public Node() {
        this.dad = null;
        this.right = null;
        this.left = null;
        this.next = null;
    }

    public Node(int info) {
        this.info = info;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getDad() {
        return dad;
    }

    public void setDad(Node dad) {
        this.dad = dad;
    }

    @Override
    public String toString() {
        return "Node{info=" + info + '}';
    }

}
