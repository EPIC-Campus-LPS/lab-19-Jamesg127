public class Node<E> {
    private E data;
    public static Node<E> next;
    public static Node<E> previous;
    public Node(E d){
        data = d;
    }
    public E getValue(){
        return data;
    }
    public void setValue(E v) {
        data = v;
    }
    public static void setNext(Node<E> n){
        next = n;
    }
    public void setPrevious(Node<E> p){
        previous = p;
    }

    public String toString(){
        String string = data.toString();
        return string;
    }
    public boolean equals(Node<E> node){
        if(node.equals(data)){
            return true;
        }
        else{
            return false;
        }
    }
}
