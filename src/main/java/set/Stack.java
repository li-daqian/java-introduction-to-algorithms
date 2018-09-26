package set;

import java.util.Arrays;

/**
 * @author LiDaQian
 */
public class Stack<T> {

    private Object[] elements;

    private int elementCount;

    public Stack () {
        elementCount = 0;
        elements = new Object[10];
    }

    public void push(T item) {
        // 自动扩容
        if (elementCount == elements.length - 1) {
            grow();
        }
        elements[elementCount++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Stack are empty.");
        }
        T element = (T) elements[--elementCount];
        // 自动缩容
        if (elements.length / 2 < elementCount) {
            System.arraycopy(elements, 0, elements, 0, elementCount - 1);
        }
        elements[elementCount] = null;
        return element;
    }

    public boolean empty() {
        return elementCount == 0;
    }

    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }
}
