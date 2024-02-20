import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySinglyLinkedListTests {

    private final MySinglyLinkedList<Integer> sll = new MySinglyLinkedList<>();

    @Test
    void add() {
        sll.add(0, 1);
        sll.add(1, 2);
        sll.add(1, 3);

        assertAll(
                "add",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(3, sll.size()),
                () -> assertEquals(3, sll.get(1)),
                () -> assertEquals(2, sll.get(2))
        );
    }

    @Test
    void addLast() {
        sll.addLast(1);

        assertAll(
                "addLast",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(1, sll.size())
        );
    }

    @Test
    void addFirst() {
        sll.addFirst(2);
        sll.addFirst(1);

        assertAll(
                "addFirst",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(1, sll.get(0)),
                () -> assertEquals(2, sll.size())
        );
    }

    @Test
    void addException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> sll.add(1, 1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }

    @Test
    void getLast() {
        sll.addLast(0);
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);

        assertAll(
                "getLast",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(6, sll.size()),
                () -> assertEquals(1, sll.get(1)),
                () -> assertEquals(5, sll.getLast())
        );
    }

    @Test
    void getFirst() {
        sll.addFirst(0);
        sll.addFirst(1);
        sll.addFirst(2);
        sll.addFirst(3);
        sll.addFirst(4);
        sll.addFirst(5);

        assertAll(
                "getFirst",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(6, sll.size()),
                () -> assertEquals(5, sll.getFirst())
        );
    }

    @Test
    void remove() {
        sll.addLast(1);
        sll.addLast(2);
        sll.remove(0);

        assertAll(
                "remove",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(1, sll.size()),
                () -> assertEquals(2, sll.get(0))
        );

        sll.removeLast();
        assertTrue(sll.isEmpty());
    }

    @Test
    void removeLast() {
        sll.add(0, 1);
        sll.add(0, 2);
        sll.removeLast();

        assertAll(
                "removeLast",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(1, sll.size()),
                () -> assertEquals(2, sll.get(0))
        );
    }

    @Test
    void removeFirst() {
        sll.addFirst(100);
        sll.addFirst(200);
        sll.removeFirst();

        assertAll(
                "removeFirst",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(1, sll.size()),
                () -> assertEquals(100, sll.get(0))
        );
    }

    @Test
    void removeException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> sll.remove(0));
        assertEquals("Index: 0, Size: 0", exception.getMessage());
    }

    @Test
    void set() {
        sll.add(0, 1);
        sll.add(1, 2);
        Integer old0 = sll.set(0, 100);
        Integer old1 = sll.set(1, 200);

        assertAll(
                "set",
                () -> assertFalse(sll.isEmpty()),
                () -> assertEquals(2, sll.size()),
                () -> assertEquals(1, old0),
                () -> assertEquals(2, old1),
                () -> assertEquals(100, sll.get(0)),
                () -> assertEquals(200, sll.get(1))
        );
    }

    @Test
    void setException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> sll.set(1, 1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }
}
