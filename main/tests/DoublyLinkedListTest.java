import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @org.junit.jupiter.api.Test
    void add() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(2);
        assertEquals(2, list.get(0));
        list.add(3);
        assertEquals(3, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 2);
        assertEquals(2, list.get(0));
        list.add(0, 3);
        assertEquals(3, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.remove();
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(3, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void get() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @org.junit.jupiter.api.Test
    void set() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 3);
        assertEquals(3, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void size() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
    }
}