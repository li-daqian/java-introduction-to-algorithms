package set;

/**
 * @author LiDaQian
 */
public class Queue<T> {

    private Object[] elements;

    private int head;

    private int tail;

    private int countElement;

    public Queue(int size) {
        this.elements = new Object[size];

        this.head = 0;
        this.tail = 0;
        this.countElement = 0;
    }

    public void enQueue(T item) {
        if (countElement == elements.length) {
            throw new IllegalStateException("Queue is full");
        }

        elements[tail] = item;

        countElement++;

        if (tail == elements.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
    }

    @SuppressWarnings("unchecked")
    public T deQueue() {
        if (countElement == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        T element = (T) elements[head];

        elements[head] = null;

        countElement--;

        if (head == elements.length - 1) {
            head = 0;
        } else {
            head++;
        }

        return element;
    }
}
