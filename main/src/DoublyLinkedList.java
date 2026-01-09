public class DoublyLinkedList<E> implements List {
    private Node<E> head;
    private int size = 0;
    @Override
    public void add(E value){
        if(head == null){
            head = new Node<>(value);
            size++;
        }
            Node<E> newValue = new Node<>(value);
            Node.setNext(newValue);
        Node<E> current = (size - 1, head);
    }
    @Override
    public void add(int i, E element) throws IndexOutOfBoundsException;
    @Override
    public void remove();
    @Override
    public Node<E> remove(int i) throws IndexOutOfBoundsException;
}
