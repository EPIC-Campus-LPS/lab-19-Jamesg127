public class Node<E> {
    private E data;
    private  Node<E> next;
    private  Node<E> previous;
    public E getData(){
        return data;
    }
    public Node<E> getNext(){
        return next;
    }
    public Node<E> getPrevious(){
        return previous;
    }
    public Node(E d) {
        data = d;
    }
    public void setPrevious(Node<E> p){
        previous = p;
    }
    public void setNext(Node<E> n){
        next = n;
    }
    public void setData(E d){
        data = d;
    }


    public String toString(){
        String string = data.toString();
        return string;
    }
}
