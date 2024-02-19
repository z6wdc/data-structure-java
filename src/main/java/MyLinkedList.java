import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    // Sentinel node
    final private Node<E> head, tail;
    private int size;

    // Double Linked List
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // Create
    public void addLast(E e) {
        Node<E> prev = tail.prev;

        Node<E> a = new Node<>(e);
        a.next = tail;
        a.prev = prev;

        tail.prev = a;
        prev.next = a;

        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        if (size == index) {
            addLast(element);
            return;
        }

        Node<E> n = getNode(index);
        Node<E> prev = n.prev;

        Node<E> a = new Node<>(element);
        a.prev = prev;
        a.next = n;

        n.prev = a;
        prev.next = a;

        size++;
    }


    // Delete
    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        checkElementIndex(index);

        Node<E> r = getNode(index);
        Node<E> prev = r.prev;
        Node<E> next = r.next;

        prev.next = next;
        next.prev = prev;

        r.next = null;
        r.prev = null;

        size--;
        return r.val;
    }

    // Read
    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).val;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    // Update
    public E set(int index, E val) {
        checkElementIndex(index);
        Node<E> n = getNode(index);
        E old = n.val;
        n.val = val;

        return old;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> p;
        if (index < size / 2) {
            p = head.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = tail.prev;
            for (int i = size - 1; i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 檢查 index 是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * 檢查 index 是否可以新增元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }
}
