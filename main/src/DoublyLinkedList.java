public class DoublyLinkedList<E> implements List<E> {
    private int size = 0;
    private Node<E> head;

    private Node<E> traverse(int i, Node<E> node) {
        if(i == 0) {
            return node;
        }
        return traverse(i - 1, node.getNext());
    }

    /**
     * Adds an element to the end of the list
     * @param element element to add to the list
     */

     @Override
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

    /**
     * Adds an element at index i to the Linked List
     * @param i index of the element
     * @param element element to add to the list
     */
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

    /**
     * Removes all elements from the list
     */
    @Override
    public void remove() {
        head = null;
        size = 0;
    }

    /**
     * removes the element at index i and returns that element
     * @param i index of the element to remove
     * @return element that is removed
     */
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

    /**
     * gets an element at index i
     * @param i index of the element
     * @return element at index i
     */
    @Override
    public E get(int i) {
        return traverse(i, head).getData();
    }

    /**
     * sets an element at index i
     * @param i index of the element to set
     * @param element new value of the element
     */
    @Override
    public void set(int i, E element) {
        traverse(i, head).setData(element);
    }

    /**
     * gets the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * checks if the list is empty
     * @return false if not empty and true if empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * translates the list as into a string format
     * @return the list as a string
     */
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