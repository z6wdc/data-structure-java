import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTests {

    private final MyArrayList<Integer> mal = new MyArrayList<>();

    @Test
    void add() {
        mal.add(0, 1);
        mal.add(1, 2);
        mal.add(1, 3);

        assertAll(
                "add",
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(3, mal.size()),
                () -> assertEquals(3, mal.get(1)),
                () -> assertEquals(2, mal.get(2))
        );
    }

    @Test
    void addLast() {
        mal.addLast(1);

        assertAll(
                "addLast",
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size())
        );
    }

    @Test
    void addFirst() {
        mal.addFirst(2);
        mal.addFirst(1);

        assertAll(
                "addFirst",
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.get(0)),
                () -> assertEquals(2, mal.size())
        );
    }

    @Test
    void addException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> mal.add(1, 1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }

    @Test
    void remove() {
        mal.addLast(1);
        mal.addLast(2);
        mal.remove(0);

        assertAll(
                "remove",
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size()),
                () -> assertEquals(2, mal.get(0))
        );

        mal.removeLast();
        assertTrue(mal.isEmpty());
    }

    @Test
    void removeLast() {
        mal.add(0, 1);
        mal.add(0, 2);
        mal.removeLast();

        assertAll(
                "removeLast",
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size()),
                () -> assertEquals(2, mal.get(0))
        );
    }

    @Test
    void removeFirst() {
        mal.addFirst(100);
        mal.addFirst(200);
        mal.removeFirst();

        assertAll(
                "removeFirst",
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size()),
                () -> assertEquals(100, mal.get(0))
        );
    }

    @Test
    void removeException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> mal.remove(0));
        assertEquals("Index: 0, Size: 0", exception.getMessage());
    }

    @Test
    void set() {
        mal.add(0, 1);
        mal.add(1, 2);
        Integer old0 = mal.set(0, 100);
        Integer old1 = mal.set(1, 200);

        assertAll(
                "set",
                () -> assertFalse(mal.isEmpty()),
                () -> assertEquals(2, mal.size()),
                () -> assertEquals(1, old0),
                () -> assertEquals(2, old1),
                () -> assertEquals(100, mal.get(0)),
                () -> assertEquals(200, mal.get(1))
        );
    }

    @Test
    void setException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> mal.set(1, 1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }
}
