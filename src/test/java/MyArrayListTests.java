import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTests {

    @Test
    void add() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.add(0,1);
        mal.add(1,2);
        mal.add(1,3);

        assertAll(
                "add",
                ()-> assertFalse(mal.isEmpty()),
                () -> assertEquals(3, mal.size()),
                () -> assertEquals(3, mal.get(1))
        );
    }

    @Test
    void addLast() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.addLast(1);

        assertAll(
                "addLast",
                ()-> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size())
        );
    }

    @Test
    void addFirst() {
        MyArrayList<Integer> mal = new MyArrayList<>(3);
        mal.addFirst(2);
        mal.addFirst(1);

        assertAll(
                "addFirst",
                ()-> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.get(0)),
                () -> assertEquals(2, mal.size())
        );
    }

    @Test
    void addException() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        Exception exception = assertThrows(IndexOutOfBoundsException.class, ()->mal.add(1,1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }

    @Test
    void remove() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.addLast(1);
        mal.addLast(2);
        mal.remove(0);

        assertAll(
                "remove",
                ()-> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size()),
                () -> assertEquals(2, mal.get(0))
        );

        mal.removeLast();
        assertTrue(mal.isEmpty());
    }

    @Test
    void removeLast() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.add(0,1);
        mal.add(0,2);
        mal.removeLast();

        assertAll(
                "removeLast",
                ()-> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size()),
                () -> assertEquals(2, mal.get(0))
        );
    }

    @Test
    void removeFirst() {
        MyArrayList<Integer> mal = new MyArrayList<>(100);
        mal.addFirst(100);
        mal.addFirst(200);
        mal.removeFirst();

        assertAll(
                "removeFirst",
                ()-> assertFalse(mal.isEmpty()),
                () -> assertEquals(1, mal.size()),
                () -> assertEquals(100, mal.get(0))
        );
    }

    @Test
    void removeException() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        Exception exception = assertThrows(IndexOutOfBoundsException.class, ()->mal.remove(0));
        assertEquals("Index: 0, Size: 0", exception.getMessage());

    }

    @Test
    void set() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.add(0,1);
        mal.add(1,2);
        mal.set(0,100);
        mal.set(1,200);

        assertAll(
                "set",
                ()-> assertFalse(mal.isEmpty()),
                () -> assertEquals(2, mal.size()),
                () -> assertEquals(100, mal.get(0)),
                () -> assertEquals(200, mal.get(1))
        );
    }

    @Test
    void setException() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        Exception exception = assertThrows(IndexOutOfBoundsException.class, ()->mal.set(1,1));
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }

}
