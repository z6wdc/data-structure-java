import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTests {

    private final MyLinkedList<Integer> mll = new MyLinkedList<>();

    @Test
    void add() {
        mll.add(0, 1);
        mll.add(1, 2);
        mll.add(1, 3);

        assertAll(
                "add",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(3, mll.size()),
                () -> assertEquals(3, mll.get(1)),
                () -> assertEquals(2, mll.get(2))
        );
    }

    @Test
    void addLast() {
        mll.addLast(1);

        assertAll(
                "addLast",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(1, mll.size())
        );
    }

    @Test
    void addFirst() {
        mll.addFirst(2);
        mll.addFirst(1);

        assertAll(
                "addFirst",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(1, mll.get(0)),
                () -> assertEquals(2, mll.size())
        );
    }

    @Test
    void addException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> mll.add(1, 1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }

    @Test
    void getLast() {
        mll.addLast(0);
        mll.addLast(1);
        mll.addLast(2);
        mll.addLast(3);
        mll.addLast(4);
        mll.addLast(5);

        assertAll(
                "getLast",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(6, mll.size()),
                () -> assertEquals(1, mll.get(1)),
                () -> assertEquals(5, mll.getLast())
        );
    }

    @Test
    void getFirst() {
        mll.addFirst(0);
        mll.addFirst(1);
        mll.addFirst(2);
        mll.addFirst(3);
        mll.addFirst(4);
        mll.addFirst(5);

        assertAll(
                "getFirst",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(6, mll.size()),
                () -> assertEquals(5, mll.getFirst())
        );
    }

    @Test
    void remove() {
        mll.addLast(1);
        mll.addLast(2);
        mll.remove(0);

        assertAll(
                "remove",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(1, mll.size()),
                () -> assertEquals(2, mll.get(0))
        );

        mll.removeLast();
        assertTrue(mll.isEmpty());
    }

    @Test
    void removeLast() {
        mll.add(0, 1);
        mll.add(0, 2);
        mll.removeLast();

        assertAll(
                "removeLast",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(1, mll.size()),
                () -> assertEquals(2, mll.get(0))
        );
    }

    @Test
    void removeFirst() {
        mll.addFirst(100);
        mll.addFirst(200);
        mll.removeFirst();

        assertAll(
                "removeFirst",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(1, mll.size()),
                () -> assertEquals(100, mll.get(0))
        );
    }

    @Test
    void removeException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> mll.remove(0));
        assertEquals("Index: 0, Size: 0", exception.getMessage());
    }

    @Test
    void set() {
        mll.add(0, 1);
        mll.add(1, 2);
        Integer old0 = mll.set(0, 100);
        Integer old1 = mll.set(1, 200);

        assertAll(
                "set",
                () -> assertFalse(mll.isEmpty()),
                () -> assertEquals(2, mll.size()),
                () -> assertEquals(1, old0),
                () -> assertEquals(2, old1),
                () -> assertEquals(100, mll.get(0)),
                () -> assertEquals(200, mll.get(1))
        );
    }

    @Test
    void setException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> mll.set(1, 1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }
}
