
public class MySinglyLinkedList<E> {
    // Sentinel node
    final private Node<E> head, tail;
    private int size;

    // Singly Linked List
    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    public MySinglyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        this.size = 0;
    }

    // Create
    public void addLast(E e) {
        if (size == 0) {
            addFirst(e);
        } else {
            add(size, e);
        }
    }

    public void addFirst(E e) {
        Node<E> x = new Node<>(e);
        Node<E> next = head.next;

        head.next = x;
        x.next = next;

        size++;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == 0) {
            addFirst(element);
            return;
        }

        Node<E> x = new Node<>(element);
        Node<E> prev = getNode(index - 1);
        Node<E> next = prev.next;

        prev.next = x;
        x.next = next;

        size++;
    }


    // Delete
    public E removeFirst() {
        checkElementIndex(0);

        Node<E> r = head.next;
        head.next = r.next;
        r.next = null;

        size--;
        return r.val;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        checkElementIndex(index);
        if (index == 0) {
            return removeFirst();
        }

        Node<E> prev = getNode(index - 1);
        Node<E> r = prev.next;
        prev.next = r.next;

        r.next = null;
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

        final E old = n.val;
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
        Node<E> n = head.next;

        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
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
}
