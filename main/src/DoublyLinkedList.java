public class DoublyLinkedList<E> implements List<E> {
    private Node<E> head;
    private int size = 0;
    public Node<E> traverse(int i, Node<E> node){
        if(i == 0){
            return node;
        }
        return traverse(i - 1, node.next);
    }
    @Override
    public void add(E element){
        if(head == null){
            head = new Node<>(element);
            size++;
            return;
        }
        Node<E> newElement = new Node<>(element);
        Node<E> current = traverse(size - 1, head);
        size++;
        newElement = current;
        newElement.setPrevious(current);
    }

    @Override
    public void add(int i, E element) throws IndexOutOfBoundsException {
        if (head == null) {
            head = new Node<>(element);
        }
        if (i == 0) {
            Node<E> newElement = new Node<>(element);
            Node<E> otherHead = head;
            head = newElement;
            newElement.next = otherHead;
            otherHead.previous = newElement;
            return;
        }
        if (i < size) {
            size++;
            Node<E> current = traverse(i, head);
            Node<E> newElement = new Node<>(element);
            current.previous.next = newElement;
            current.previous = newElement;
            newElement.previous = current.previous;
            newElement.next = current;
        }
    }


    @Override
    public void remove() {
        head = null;
        size = 0;
    }
    @Override
    public E remove(int x) {
        if (x >= size) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        Node<E> cur = traverse(x, head);


        cur.previous.next = cur.next;
        cur.next.previous = cur.previous;

        return cur.data;
    }


    @Override
    public E get(int x) {
        return traverse(x, head).data;
    }
    @Override
    public void set(int x, E element) {
        traverse(x, head).data = element;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public String toString(){
        String result = "";
        if(head != null) {
            result += head.data;
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
                result += current.data + ", ";
            }
        }
        return result;
    }
}