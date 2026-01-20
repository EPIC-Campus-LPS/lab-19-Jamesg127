public class Node<E> {
    public E data;
    public  Node<E> next;
    public  Node<E> previous;
    public Node(E d) {
        data = d;
    }
    public void setPrevious(Node<E> p){
        previous = p;
    }

    public String toString(){
        String string = data.toString();
        return string;
    }
}
