import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    // 儲存
    private E[] data;
    // 當前元素個數
    private int size;
    // 初始容量
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    // Create
    public void add(int index, E e) {
        checkPositionIndex(index);

        final int cap = data.length;
        if (size == cap) {
            resize(2 * cap);
        }

        if (size > index) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }

        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // Delete
    public E remove(int index) {
        checkElementIndex(index);

        final int cap = data.length;
        if (cap / 4 > size) {
            resize(cap / 2);
        }

        E old = data[index];
        if (size > (index + 1)) {
            System.arraycopy(data, index + 1, data, index, size - (index + 1));
        }

        data[size - 1] = null;
        size--;

        return old;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // Read
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    // Update
    public E set(int index, E element) {
        checkElementIndex(index);
        E current = data[index];
        data[index] = element;
        return current;
    }

    private void resize(int newCap) {
        if (size > newCap) {
            return;
        }

        E[] temp = (E[]) new Object[newCap];
        if (size > 0) {
            System.arraycopy(data, 0, temp, 0, size);
        }

        data = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
     * 檢查 index 是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = 0;

            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public E next() {
                return data[p++];
            }
        };
    }
}

