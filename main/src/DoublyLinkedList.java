public class DoublyLinkedList<E> implements List<E> {
    private int size = 0;
    private Node<E> head;

    private Node<E> traverse(int i, Node<E> node) {
        if(i == 0) {
            return node;
        }
        return traverse(i - 1, node.getNext());
    }

    public void add(E element) {
        if(size == 0) {
            head = new Node<>(element);
            size++;
            return;
        }
        size++;

        Node<E> newElem = new Node<>(element);
        Node<E> cur = traverse(size - 2, head);

        cur.setNext(newElem);
        newElem.setPrevious(cur);
    }

    @Override
    public void add(int i, E element) {
        if (head == null) {
            head = new Node<>(element);
        }
        if (i == 0) {
            Node<E> newElem = new Node<>(element);
            Node<E> oldHead = head;
            head = newElem;
            newElem.setNext(oldHead);
            oldHead.setPrevious(newElem);
            return;
        }
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        size++;

        Node<E> cur = traverse(i, head);

        Node<E> newElem = new Node<>(element);

        cur.getPrevious().setNext(newElem);
        cur.setPrevious(newElem);

        newElem.setPrevious(cur.getPrevious());
        newElem.setNext(cur);
    }

    @Override
    public void remove() {
        head = null;
        size = 0;
    }

    @Override
    public E remove(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        size--;

        Node<E> cur = traverse(i, head);

        cur.getPrevious().setNext(cur.getNext());
        cur.getNext().setPrevious(cur.getPrevious());

        return cur.getData();
    }

    @Override
    public E get(int i) {
        return traverse(i, head).getData();
    }

    @Override
    public void set(int i, E element) {
        traverse(i, head).setData(element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String result = "";

        if(head != null) {
            result += head.getData();

            Node<E> cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
                result += cur.getData() + ", ";
            }
        }

        return result;
    }
}